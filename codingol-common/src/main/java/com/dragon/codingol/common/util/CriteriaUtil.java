package com.dragon.codingol.common.util;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.util.StringUtils;

import com.dragon.codingol.common.Pager;
import com.dragon.codingol.common.SystemConfig;
import com.dragon.codingol.domain.base.RelativeTable;

public class CriteriaUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1911171063321130467L;
	private Pager pager;
	private DetachedCriteria detachedCriteria;
	private String fields;  // 查询需要显示的字段
	private Class tclass;
	private int limit;
	private int page;
	private String status;
	private boolean isorder = false;
	
	public CriteriaUtil(){
		pager = new Pager();
		limit =  pager.getLimit();
		this.status = SystemConfig.getDatastatus();
	}
	
	public void initProjections() {
		if(!StringUtils.isEmpty(fields)){
			String field[] = fields.split(",");
			ProjectionList pList = Projections.projectionList();  
			for(String f : field){
				if(!StringUtils.isEmpty(f)){
					pList.add(Projections.property(f).as(f)); 
				}
			}
			detachedCriteria.setProjection(pList);
		}
	}
  
	public void installParams(Object search, Map<String, String[]> parameterMap){
		
		pager.setPage(this.page);
		this.detachedCriteria = DetachedCriteria.forClass(search.getClass());
		this.tclass = search.getClass();
		initProjections();
		
		this.detachedCriteria.setResultTransformer(Transformers.aliasToBean(search.getClass()));
		
  		PropertyDescriptor descriptors[] =   PropertyUtils.getPropertyDescriptors(search);
  		// 获得对象属性中的name 
  		List<String> names = new ArrayList<String>(10);
  		for (int i = 0; i < descriptors.length; i++) {
  			names.add(descriptors[i].getName());
  		}
  		
  		//默认数据状态， 如果有status列， 则默认不显示删除数据（即状态为0的数据）
  		if(names.contains(status) && !parameterMap.containsKey(status)){
  			this.notEq(status, 0);
  		}
  		
  		for (int i = 0; i < descriptors.length; i++) {
  			
  			String name = descriptors[i].getName();
  			String type = descriptors[i].getPropertyType().getName();
  			
  			if ("class".equals(name)||"ids".equals(name)||"page".equals(name)
  					||"rows".equals(name)||"sort".equals(name)||"order".equals(name)) {
  				continue;  
  			}
  			try {
  			 
  				Transient t = search.getClass().getDeclaredMethod("get"+name.substring(0,1).toUpperCase()+name.substring(1)).getAnnotation(Transient.class);
  				if(t!=null) {
  					continue;
  				}
  				if (PropertyUtils.isReadable(search, name)) {
  					// 添加 判断是否有区间值
  					String beginValue = null;
  					String endValue = null;
  					if (parameterMap.containsKey(name+"_begin")) {
						beginValue = parameterMap.get(name+"_begin")[0].trim();
					}
  					if (parameterMap.containsKey(name+"_end")) {
  						endValue = parameterMap.get(name+"_end")[0].trim();
  					}
  					
  					// 根据类型分类处理
  					if("java.lang.String".equals(type)){
  						Object value = PropertyUtils.getSimpleProperty(search, name);
  						String searchValue = null;
  						if(!StringUtils.isEmpty(value)){
  							searchValue = value.toString().trim();
  						}else{
  							continue;
  						}
  						if(searchValue!=null&&!"".equals(searchValue)){
  							if(name.endsWith("id"))
  								this.eq(name,  searchValue );
  							else
  								this.like(name, "%"+ searchValue+"%" );
  						}
  					}else if("java.lang.Integer".equals(type)){
  						if (beginValue != null && !"".equals(beginValue)) {
	  						this.ge(name, Integer.parseInt(beginValue));
	  					}
	  					if (endValue != null && !"".equals(endValue)) {
	  						this.le(name, Integer.parseInt(endValue));
	  					}
	  					Object value = PropertyUtils.getSimpleProperty(search, name);
	  					if(!StringUtils.isEmpty(value)){
	  						this.eq(name, value);
	  					}
  					} else if("java.math.BigDecimal".equals(type)){
  						if (!StringUtils.isEmpty(beginValue)) {
  							if (beginValue.contains(".")) {
  								this.ge(name, BigDecimal.valueOf(Double.parseDouble(beginValue)));
							} else {
								this.ge(name, BigDecimal.valueOf(Long.parseLong(beginValue)));
							}
	  					}
	  					if (!StringUtils.isEmpty(endValue)) {
	  						if (beginValue.contains(".")) {
	  							this.le(name, BigDecimal.valueOf(Double.parseDouble(endValue)));
							} else {
								this.le(name, BigDecimal.valueOf(Long.parseLong(endValue)));
							}
	  					}
	  					Object value = PropertyUtils.getSimpleProperty(search, name);
	  					if(!StringUtils.isEmpty(endValue)){
	  						this.eq(name, value);
	  					}
  					}else if("java.lang.Short".equals(type)){
  						if (beginValue != null && !"".equals(beginValue)) {
	  						this.ge(name, Short.parseShort(beginValue));
	  					}
	  					if (endValue != null && !"".equals(endValue)) {
	  						this.le(name, Short.parseShort(endValue));
	  					}
	  					Object value = PropertyUtils.getSimpleProperty(search, name);
	  					if(!StringUtils.isEmpty(endValue)){
	  						this.eq(name, value);
	  					}
  					}else if("java.lang.Long".equals(type)){
  						if (beginValue != null && !"".equals(beginValue)) {
	  						this.ge(name, Long.parseLong(beginValue));
	  					}
	  					if (endValue != null && !"".equals(endValue)) {
	  						this.le(name, Long.parseLong(endValue));
	  					}
	  					Object value = PropertyUtils.getSimpleProperty(search, name);
	  					if(!StringUtils.isEmpty(endValue)){
	  						this.eq(name, value);
	  					}
  					}else if ("java.util.Date".equals(type)) {
  						// 由于前台使用时间控件，目前仅提供下面两种格式支持。
  						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  						SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
  						if (!StringUtils.isEmpty(beginValue)) {
  							if (beginValue.length() == 19) {
  								this.ge(name, sdf1.parse(beginValue));
							} else if (beginValue.length() == 10) {
								this.ge(name, sdf2.parse(beginValue));
							}
	  					}
  						if (!StringUtils.isEmpty(endValue)) {
  							if (endValue.length() == 19) {
  								this.le(name, sdf1.parse(endValue));
  							} else if (endValue.length() == 10) {
  								// 对于"yyyy-MM-dd"格式日期，因时间默认为0，故此添加" 23:23:59"并使用sdf1解析，以方便查询日期时间数据
  								this.le(name, sdf1.parse(endValue + " 23:23:59"));
  							}
  						}
	  					Object value = PropertyUtils.getSimpleProperty(search, name);
	  					if(!StringUtils.isEmpty(endValue)){
	  						this.eq(name, value);
	  					}
  						if (null != value) {
  							// 判断开始时间
  							if (name.contains("_begin")) {
  								String realName =  name.substring(0, name.indexOf("_"));
  								if (name.endsWith("_begin")  && names.contains(realName)) {
  									this.ge(realName, value);
  								}
  							}
  							// 判断结束时间
  							else if (name.contains("_end")) {
  								String realName = name.substring(0, name.indexOf("_"));
  								if (name.endsWith("_end") && names.contains(realName)) {
  									this.le(name, value);
  								}
  							}
  							else {
  								this.eq(name, value);
  							}
  						}
  					}
  				}
  			} catch (Exception e) {
  				e.printStackTrace();
  			}
  		}
	}
	
	
	public void add(Criterion c) {
		detachedCriteria.add(c);
	}
	 
	public void or(Criterion c1, Criterion c2) {
		this.detachedCriteria.add(Restrictions.or(c1, c2));
	}
	 
	public void addOrderAsc(String name) { 
		isorder = true;
		detachedCriteria.addOrder(Order.asc(name));
	}

	public void addOrderDesc(String name) { 
		isorder = true;
		detachedCriteria.addOrder(Order.desc(name));
	}
 
	public void eq(String key, Object value) {
		if (!StringUtils.isEmpty(value)) {
			detachedCriteria.add(Restrictions.eq(key, value));
		}
	}
	 
	public void notEq(String key, Object value) {
		if (!StringUtils.isEmpty(value)) {
			detachedCriteria.add(Restrictions.ne(key, value));
		}
	}

	
	public void like(String key, Object value) {
		if (!StringUtils.isEmpty(value)) {
			detachedCriteria.add(Restrictions.like(key, value));
		}
	}

	public void empty(String key){
		if (!StringUtils.isEmpty(key)) {
			detachedCriteria.add(Restrictions.or(Restrictions.isNull(key), Restrictions.eq(key, "")));
		}
	}
	
	/**
	 * 多关键字模糊查询，关键字用空格分隔
	 * 
	 * @param keywords
	 */
	public void multipleKeywords(String property, String keywords) {
		if(keywords==null)
			return;
		String[] keys = keywords.trim().split("\\s+");
		for (String key : keys) {
			like(property, "%"+key+"%");
		}
	}
	 
	public void gt(String key, Object value) {
		if (!StringUtils.isEmpty(value)) {
			detachedCriteria.add(Restrictions.gt(key, value));
		}
	}

	public void lt(String key, Object value) {
		if (!StringUtils.isEmpty(value)) {
			detachedCriteria.add(Restrictions.lt(key, value));
		}
	}

	
	public void le(String key, Object value) {
		if (!StringUtils.isEmpty(value)) {
			detachedCriteria.add(Restrictions.le(key, value));
		}
	}

	 
	public void ge(String key, Object value) {
		if (!StringUtils.isEmpty(value)) {
			detachedCriteria.add(Restrictions.ge(key, value));
		}
	}
 
	public void in(String key, Object[] value) {
		if (!StringUtils.isEmpty(key) && value[0] != "") {
			detachedCriteria.add(Restrictions.in(key, value));
		}
	}

	 
	public void isNull(String key) {
		detachedCriteria.add(Restrictions.isNull(key));
		 
	}

 
	public void isNotNull(String key) {
		detachedCriteria.add(Restrictions.isNotNull(key));
	}
 
	public void between(String key, Object start, Object end) {
		Criterion c = null;// 写入between查询条件
		if (!start.equals(null) && !end.equals(null)) {
			c = Restrictions.between(key, start, end);
		} else if (!start.equals(null)) {
			c = Restrictions.ge(key, start);
		} else if (!end.equals(null)) {
			c = Restrictions.le(key, end);
		}
		if(c !=null)
			detachedCriteria.add(c);
	}
	
	public void sql(String sql) {
		Restrictions.sqlRestriction(sql);
	}

	public void sql(String sql, Object[] objects, Type[] type) {
		Restrictions.sqlRestriction(sql, objects, type);
	}

	public void sql(String sql, Object objects, Type type) {
		Restrictions.sqlRestriction(sql, objects, type);
	}

	public void exists(Object o){
		Table table = o.getClass().getAnnotation(Table.class);
		Table mainTable = (Table) tclass.getAnnotation(Table.class);
		if(table==null || mainTable == null)
			return;
		String main = mainTable.name();
		
		StringBuilder sql = new StringBuilder(" exists (select 1 from ");
		sql.append(table.name());
		
		StringBuilder where = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		List<Type> types = new ArrayList<Type>();
		Method method[] =o.getClass().getDeclaredMethods();
		for(Method f : method){
			if(f.getName().startsWith("set")){
				continue;
			}
			try {
				Object v  = f.invoke(o, new Object[] {});
				Column column = f.getAnnotation(Column.class);
				RelativeTable relativeTable = f.getAnnotation(RelativeTable.class);
				if(relativeTable!=null && relativeTable.table().equals(main)){
					sql.append(" as t1 where {alias}.");
					sql.append(relativeTable.id());
					sql.append("  = t1.");
					sql.append(column.name().replace("[", "").replace("]", ""));
				}
				if(!StringUtils.isEmpty(v)){
					where.append(" and t1.");
					where.append(column.name().replace("[", "").replace("]", ""));
					where.append("=?");
					param.add(v);
					 
					types.add((Type)StandardBasicTypes.STRING);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		sql.append(where);
		sql.append(")");
		Type[] ts = new Type[types.size()];
		detachedCriteria.add(Restrictions.sqlRestriction(sql.toString(), param.toArray(),  types.toArray(ts)));
	}
 
	
	public void notexists(Object o){
		Table table = o.getClass().getAnnotation(Table.class);
		Table mainTable = (Table) tclass.getAnnotation(Table.class);
		if(table==null || mainTable == null)
			return;
		String main = mainTable.name();
		
		StringBuilder sql = new StringBuilder(" not exists (select 1 from ");
		sql.append(table.name());
		
		StringBuilder where = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		List<Type> types = new ArrayList<Type>();
		Method method[] =o.getClass().getDeclaredMethods();
		for(Method f : method){
			if(f.getName().startsWith("set")){
				continue;
			}
			try {
				Object v  = f.invoke(o, new Object[] {});
				Column column = f.getAnnotation(Column.class);
				RelativeTable relativeTable = f.getAnnotation(RelativeTable.class);
				if(relativeTable!=null && relativeTable.table().equals(main)){
					sql.append(" as t1 where {alias}.");
					sql.append(relativeTable.id());
					sql.append("  = t1.");
					sql.append(column.name().replace("[", "").replace("]", ""));
				}
				if(!StringUtils.isEmpty(v)){
					where.append(" and t1.");
					where.append(column.name().replace("[", "").replace("]", ""));
					where.append("=?");
					param.add(v);
					 
					types.add((Type)StandardBasicTypes.STRING);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		sql.append(where);
		sql.append(")");
		Type[] ts = new Type[types.size()];
		detachedCriteria.add(Restrictions.sqlRestriction(sql.toString(), param.toArray(),  types.toArray(ts)));
	}
	
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Class getTclass() {
		return tclass;
	}

	public void setTclass(Class tclass) {
		this.tclass = tclass;
	}

	public boolean isIsorder() {
		return isorder;
	}

	public void setIsorder(boolean isorder) {
		this.isorder = isorder;
	}
	
}
