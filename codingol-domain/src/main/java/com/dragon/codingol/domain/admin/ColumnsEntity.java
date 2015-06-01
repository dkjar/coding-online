package com.dragon.codingol.domain.admin;

import java.math.BigInteger;

public class ColumnsEntity {

	private String columnName;
	private String typeid;
	private String dataType;
	private String columnComment;
	private BigInteger numericPrecision;
	private BigInteger numericScale;
	private BigInteger characterMaximumLength;
	private String isNullable;
	private String fieldType;
	private String fieldName;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public BigInteger getNumericPrecision() {
		return numericPrecision;
	}

	public void setNumericPrecision(BigInteger numericPrecision) {
		this.numericPrecision = numericPrecision;
	}

	public BigInteger getNumericScale() {
		return numericScale;
	}

	public void setNumericScale(BigInteger numericScale) {
		this.numericScale = numericScale;
	}

	public Integer getCharacterMaximumLength() {
		if(characterMaximumLength!=null)
			return characterMaximumLength.intValue();
		return null;
	}

	public void setCharacterMaximumLength(BigInteger characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}

	public String getIsNullable() {
		if (("YES".equals(isNullable)) || ("yes".equals(isNullable))
				|| ("y".equals(isNullable)) || ("Y".equals(isNullable))
				|| ("f".equals(isNullable)))
			return "Y";
		if (("NO".equals(isNullable)) || ("N".equals(isNullable))
				|| ("no".equals(isNullable)) || ("n".equals(isNullable))
				|| ("t".equals(isNullable)))
			return "N";
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	public String getFieldType() {
		if (dataType.contains("char"))
			return "java.lang.String";
		else if (dataType.contains("int"))
			return "java.lang.Integer";
		else if (dataType.contains("float"))
			return "java.lang.Float";
		else if (dataType.contains("double"))
			return "java.lang.Double";
		else if (dataType.contains("number"))
			if (numericPrecision != null && numericScale.intValue() > 0)
				return "java.math.BigDecimal";
			else if (numericPrecision != null && numericScale.intValue() > 10)
				return "java.lang.Long";
			else
				return "java.lang.Integer";
		else if (dataType.contains("decimal"))
			return "BigDecimal";
		else if (dataType.contains("date"))
			return "java.util.Date";
		else if (dataType.contains("time"))
			return "java.util.Date";
		else if (dataType.contains("blob"))
			return "byte[]";
		else if (dataType.contains("clob"))
			return "java.sql.Clob";
		else if (dataType.contains("numeric"))
			return "BigDecimal";
		else
			return "java.lang.Object";
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldName() {
		return columnName.toLowerCase();
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
