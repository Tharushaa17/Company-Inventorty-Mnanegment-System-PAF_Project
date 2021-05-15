package com;

import com.Buyers;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Servlet implementation class BuyerAPI
 */
@WebServlet("/BuyerAPI")
public class BuyerAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	Buyers BuyersObj = new Buyers();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = BuyersObj.insertBuyers(request.getParameter("FristName"),
												request.getParameter("LastName"),
												request.getParameter("Username"),
												request.getParameter("MobileNu"),
												request.getParameter("Email"),
												request.getParameter("Address"),
												request.getParameter("Password"));
												
				response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	private static Map getParasMap(HttpServletRequest request)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		try{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
		for (String param : params){
			
				String[] p = param.split("=");
				map.put(p[0], p[1]);
				}
			}
			catch (Exception e){
			}
		
		return map;
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		  String output = BuyersObj.updateBuyer(paras.get("hidBidSave").toString(),
												paras.get("FristName").toString(),
												paras.get("LastName").toString(),
												paras.get("Username").toString(),
												paras.get("MobileNu").toString(),
												paras.get("Email").toString(),
												paras.get("Address").toString(),
												paras.get("Password").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		{
			Map paras = getParasMap(request);
			String output = BuyersObj.deleteBuyers(paras.get("Bid").toString());
			response.getWriter().write(output);
			}
	}

}
