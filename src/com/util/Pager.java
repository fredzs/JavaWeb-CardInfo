package com.util;
/**
 *用法:
 *  在Action中，定义:   Pager p = new Pager();  <b>注意变量名必须为p</b><br/>
 *  <pre>
 *  在jsp页面中，包含_pager.jsp, url参数可以使用各种语法的变量, 如下:<br/>
 *     <s:include value="/_pager.jsp"><br/>
 *         <s:param name="url">a/applist?appIntId=<s:property value="appIntId"/>&other=${other}>/s:param><br/>
 *     </s:include><br/>	 
 *  <b>注意：如果url中不包含任何参数，那么，url应以?结尾， 如：a/applist?</b><br/>
 *  </pre>
 */
public class Pager {
	public final static Integer DEFAULT_PAGESIZE = 10;//每页显示的item的数量
	public final static boolean DEFAULT_NEEDSTOTAL = true;
	public final static Integer DEFAULT_SHOWPAGE = 10;//页面栏内显示的页面个数
	public final static Integer MAX_PAGE_SIZE = 1000;

	private long total;
	private Integer pageNow = 1;
	private Integer pageSize = DEFAULT_PAGESIZE;
	private boolean needsTotal = DEFAULT_NEEDSTOTAL;
	private Integer showPage = DEFAULT_SHOWPAGE;

	public Pager() {
	}
	
	public static Pager defaultPager() {
		return new Pager();
	}
	
	/**
	 * 0 based start position
	 * @return
	 */
	public Integer getStart() {
		return (pageNow - 1) * pageSize;
	}
	
	/**
	 * 1 based pageNow
	 * @return
	 */
	public Integer getPageNow() {
		return pageNow;
	}
	
	/**
	 * 1 based pageNow
	 * @param pageNow
	 */
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if (pageSize > MAX_PAGE_SIZE) pageSize = MAX_PAGE_SIZE;
		this.pageSize = pageSize;
	}
	public boolean isNeedsTotal() {
		return needsTotal;
	}
	public void setNeedsTotal(boolean needsTotal) {
		this.needsTotal = needsTotal;
	}
	public Integer getShowPage() {
		return showPage;
	}
	public void setShowPage(Integer showPage) {
		this.showPage = showPage;
	}

}
