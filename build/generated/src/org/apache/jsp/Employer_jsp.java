package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Employer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta author=\"Hoàng Tùng Lâm\" content=\"Bài tập lớn\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/CSS/header.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/CSS/employer.css\">\r\n");
      out.write("        <!-- <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> -->\r\n");
      out.write("        <!-- <meta http-equiv=\"refresh\" content=\"3\" > -->\r\n");
      out.write("        <link rel=\"icon\" href=\"styles/Images/logo.png\">\r\n");
      out.write("        <title>Employer | TopJob</title>\r\n");
      out.write("        <style >\r\n");
      out.write("            /**/\r\n");
      out.write("            \r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <section class=\"header\">\r\n");
      out.write("            <div class header-contents>\r\n");
      out.write("                <a class=\"logo\" href=\"index.html\">\r\n");
      out.write("                    <img src=\"styles/Images/logo_small.png\">\r\n");
      out.write("                </a>\r\n");
      out.write("\r\n");
      out.write("                <nav class=\"nav\">\r\n");
      out.write("                    <li class=\"nav__itembox\"> <a class=\"nav__itemsred\" href=\"Employer.jsp\">Profile</a> </li>\r\n");
      out.write("                    <li class=\"nav__itembox\"> <a class=\"nav__items\" href=\"job.jsp\">Jobs</a> </li>\t\r\n");
      out.write("                    <li class=\"nav__itembox\"> <a class=\"nav__items\" href=\"index.html\">Signout</a> </li>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <div class=\"nav_replace\">\r\n");
      out.write("            <li class=\"nav__itemboxnew\"> <a class=\"nav__itemsrednew\" href=\"Employer.jsp\">Profile</a> </li>\r\n");
      out.write("            <li class=\"nav__itemboxnew\"> <a class=\"nav__itemsnew\" href=\"job.jsp\">Jobs</a> </li>\r\n");
      out.write("            <li class=\"nav__itemboxnew\"> <a class=\"nav__itemsnew\" href=\"index.html\">Signout</a> </li>\r\n");
      out.write("        </div>\r\n");
      out.write("        <form action=\"EmProServlet\" method=\"post\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"ok\">\r\n");
      out.write("            <label>Full name</label>\r\n");
      out.write("            <input type=\"text\" name=\"name\" value=\"");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("\" required>\r\n");
      out.write("            <label>Company</label>\r\n");
      out.write("            <input type=\"text\" name=\"company\" value=\"");
      if (_jspx_meth_c_out_1(_jspx_page_context))
        return;
      out.write("\" required>\r\n");
      out.write("            <input type=\"submit\" value=\"Save\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${employer.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent(null);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${employer.company}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }
}
