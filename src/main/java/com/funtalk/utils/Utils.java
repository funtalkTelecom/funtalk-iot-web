package com.funtalk.utils;

import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static final Logger log = LoggerFactory.getLogger(Utils.class);


	public static String returnResult(Result res){
		return returnJson(res.getCode(), res.getMsg());
	}

		private static String returnJson(int code, Object data){
			Result res = new Result(code, data);
			JSONObject jobj = JSONObject.fromObject(res);

			return render(jobj.toString(), "text/json;charset=UTF-8");
	}
	
	public static String renderHtml(HttpServletResponse response,String text) {
		return render(text, "text/html;charset=UTF-8");
	}
	public static String renderJson(HttpServletResponse response,String text) {
		return render(text, "text/json;charset=UTF-8");
	}

	public static String renderXml(String text) {
		return render(text, "text/xml;charset=UTF-8");
	}
	
	public static String render(String text, String contentType) {
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		PrintWriter w = null;
		try{
			response.setHeader("Cache-Control", "no-cache");
			response.setContentType(contentType);
			w = response.getWriter();
			w.write(text);
			w.flush();
		} catch (Exception e) {
			log.error("", e);
		} finally {
			if(w != null){
				w.close();
				w = null;
			}
		}
		return null;
	}
    /*
	 * 是否以AJAX的方式提交的
	 * @return
	 * */

	public final static boolean isAjax(HttpServletRequest request){

		String requestType =request.getHeader("X-Requested-With");
		String app = request.getParameter("__app");
		if ((requestType != null && requestType.equals("XMLHttpRequest")) ||(app != null && "xcx".equals(app))) {

			return true;
		} else {
			return false;
		}
	}


	public static String formatXlsCell(HSSFCell cell) {

		if (cell == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("0.00");
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
				//日期格式的处理
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
				}
				return df.format(cell.getNumericCellValue());
			//字符串
			case HSSFCell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			// 公式
			case HSSFCell.CELL_TYPE_FORMULA:
				return cell.getCellFormula();
			// 空白
			case HSSFCell.CELL_TYPE_BLANK:
				return "";
			// 布尔取值
			case HSSFCell.CELL_TYPE_BOOLEAN:
				return cell.getBooleanCellValue() + "";
			//错误类型
			case HSSFCell.CELL_TYPE_ERROR:
				return cell.getErrorCellValue() + "";
		}

		return "";
	}


	public static  Map<String,String> getParamMap(HttpServletRequest request) {
		Map<String,String> params = new HashMap<>();
		Enumeration<?> e= request.getParameterNames();
		while (e.hasMoreElements()) {
			String object = (String) e.nextElement();
			String[] values = (String[])request.getParameterValues(object);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(object, valueStr);
		}
		return params;
	}


	public static String getParamBody(HttpServletRequest request) {
		InputStream is = null;
		BufferedReader reader = null;
		try {
			is = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuffer buffer = new StringBuffer();
			String line=null;
			while((line = reader.readLine())!=null){
				buffer.append(line);
			}
			return buffer.toString();
		} catch (Exception e) {
			log.error("解析参数流异常",e);
			return null;
		}finally{
			try {
				if(is != null) {
					is.close();
					is = null;
				}
				if(reader != null){
					reader.close();
					reader = null;
				}
			} catch (IOException e) {
				log.error("",e);
			}
		}
	}



	public static Map<String, String> xmlToMap(String strXML) throws Exception {
		try {
			Map<String, String> data = new HashMap<String, String>();
			DocumentBuilder documentBuilder = newDocumentBuilder();
			InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
			org.w3c.dom.Document doc = documentBuilder.parse(stream);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getDocumentElement().getChildNodes();
			for (int idx = 0; idx < nodeList.getLength(); ++idx) {
				Node node = nodeList.item(idx);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					org.w3c.dom.Element element = (org.w3c.dom.Element) node;
					data.put(element.getNodeName(), element.getTextContent());
				}
			}
			try {
				stream.close();
			} catch (Exception ex) {
				// do nothing
			}
			return data;
		} catch (Exception ex) {
			log.info("Invalid XML, can not convert to map. Error message: {}. XML content: {}", ex.getMessage(), strXML);
			throw ex;
		}

	}

	/**
	 * 将Map转换为XML格式的字符串
	 *
	 * @param data Map类型数据
	 * @return XML格式的字符串
	 * @throws Exception
	 */
	public static String mapToXml(Map<String, String> data) throws Exception {
		org.w3c.dom.Document document = newDocument();
		org.w3c.dom.Element root = document.createElement("xml");
		document.appendChild(root);
		for (String key: data.keySet()) {
			String value = data.get(key);
			if (value == null) {
				value = "";
			}
			value = value.trim();
			org.w3c.dom.Element filed = document.createElement(key);
			filed.appendChild(document.createTextNode(value));
			root.appendChild(filed);
		}
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(document);
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);
		String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
		try {
			writer.close();
		}
		catch (Exception ex) {
		}
		return output;
	}


	public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
		documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		documentBuilderFactory.setXIncludeAware(false);
		documentBuilderFactory.setExpandEntityReferences(false);

		return documentBuilderFactory.newDocumentBuilder();
	}

	public static Document newDocument() throws ParserConfigurationException {
		return newDocumentBuilder().newDocument();
	}


	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			System.out.println("-------Proxy-Client-IP------>"+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			System.out.println("-------WL-Proxy-Client-IP------>"+ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			System.out.println("-------HTTP_CLIENT_IP------>"+ip);

		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			System.out.println("-------HTTP_X_FORWARDED_FOR------>"+ip);

		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			System.out.println("-------WL-Proxy-Client-IP------>"+ip);

		}
		return ip;
	}


	public static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}




}
