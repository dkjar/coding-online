package com.dragon.codingol.common;

import java.io.Serializable;

/**
 * 分页参数类
 * 
 */
public class Pager implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1153135403494789092L;
	
	public static final int DEFAULT_PAGE_SIZE = 20;

    private int limit;
    private int page; 
    private int total; 
    private Object rows;

    public Pager() {
        this.page = 1;
        this.limit = DEFAULT_PAGE_SIZE;
    }

    /**
     * 
     * @param currentPage
     * @param pageSize
     */
    public Pager(int page, int limit) {
        this.limit = limit;
        this.page = page;
    }

    public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		if(limit < 1){
			limit = 1;
		}
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}
	
}
