package com.util;
/**
 *�÷�:
 *  ��Action�У�����:   Pager p = new Pager();  <b>ע�����������Ϊp</b><br/>
 *  <pre>
 *  ��jspҳ���У�����_pager.jsp, url��������ʹ�ø����﷨�ı���, ����:<br/>
 *     <s:include value="/_pager.jsp"><br/>
 *         <s:param name="url">a/applist?appIntId=<s:property value="appIntId"/>&other=${other}>/s:param><br/>
 *     </s:include><br/>	 
 *  <b>ע�⣺���url�в������κβ�������ô��urlӦ��?��β�� �磺a/applist?</b><br/>
 *  </pre>
 */
public class Pager {
	public final static Integer DEFAULT_PAGESIZE = 10;//ÿҳ��ʾ��item������
	public final static boolean DEFAULT_NEEDSTOTAL = true;
	public final static Integer DEFAULT_SHOWPAGE = 10;//ҳ��������ʾ��ҳ�����
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
