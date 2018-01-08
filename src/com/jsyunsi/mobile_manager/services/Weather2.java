package com.jsyunsi.mobile_manager.services;

import java.io.BufferedReader;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.SocketTimeoutException;  
import java.net.URL;  
import java.net.URLConnection;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;

import net.sf.json.JSONObject;
  
/** 
 * java�����������������Ԥ���ӿ� 
 *  
 * @author Administrator 
 *  
 */  
public class Weather2 {  
  
    /** 
     * ��ȡһ������<br> 
     * �� �� ����getWeekWeatherMap <br> 
     * @param Cityid  ���б��� 
     */  
    public static List<Map<String, Object>> getWeekWeatherMap(String Cityid)  
            throws IOException, NullPointerException {  
        // ������������̨��API  
        URL url = new URL("http://m.weather.com.cn/data/" + Cityid + ".html");  
        URLConnection connectionData = url.openConnection();  
        connectionData.setConnectTimeout(1000);  
        // �õ�1��6����������  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(  
                    connectionData.getInputStream(), "UTF-8"));  
            StringBuilder sb = new StringBuilder();  
            String line = null;  
            while ((line = br.readLine()) != null)  
                sb.append(line);  
            String datas = sb.toString();  
            System.out.println(datas);  
            JSONObject jsonData = JSONObject.fromObject(datas);  
            JSONObject info = jsonData.getJSONObject("weatherinfo");  
            for (int i = 1; i <= 6; i++) {  
                // �õ�δ��6�������  
                Calendar cal = Calendar.getInstance();  
                cal.add(Calendar.DAY_OF_YEAR, i - 1);  
                Date date = cal.getTime();  
                SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd��");  
                Map<String, Object> map = new HashMap<String, Object>();  
                map.put("city", info.getString("city").toString());// ����  
                map.put("date_y", sf.format(date));// ����  
                map.put("week", getWeek(cal.get(Calendar.DAY_OF_WEEK)));// ����  
                map.put("fchh", info.getString("fchh").toString());// ����ʱ��  
                map.put("weather", info.getString("weather" + i).toString());// ����  
                map.put("temp", info.getString("temp" + i).toString());// �¶�  
                map.put("wind", info.getString("wind" + i).toString());// ���  
                map.put("fl", info.getString("fl" + i).toString());// ����  
                // map.put("index", info.getString("index").toString());//  
                // ����Ĵ���ָ��  
                // map.put("index_uv", info.getString("index_uv").toString());//  
                // ����ָ��  
                // map.put("index_tr", info.getString("index_tr").toString());//  
                // ����ָ��  
                // map.put("index_co", info.getString("index_co").toString());//  
                // ����ָ��  
                // map.put("index_cl", info.getString("index_cl").toString());//  
                // ����ָ��  
                // map.put("index_xc", info.getString("index_xc").toString());//  
                // ϴ��ָ��  
                // map.put("index_d", info.getString("index_d").toString());//  
                // ������ϸ����ָ��  
                list.add(map);  
            }  
        } catch (SocketTimeoutException e) {  
            System.out.println("���ӳ�ʱ");  
        } catch (FileNotFoundException e) {  
            System.out.println("�����ļ�����");  
        }  
  
        return list;  
  
    }  
  
    /** 
     *  
     * ��ȡʵʱ����1<br> 
     * �� �� ���� getTodayWeather <br> 
     *  
     * @param Cityid 
     *            ���б��� 
     */  
    public static Map<String, Object> getTodayWeather1(String Cityid)  
            throws IOException, NullPointerException {  
        // ������������̨��API  
        URL url = new URL("http://www.weather.com.cn/data/sk/" + Cityid  
                + ".html");  
        URLConnection connectionData = url.openConnection();  
        connectionData.setConnectTimeout(1000);  
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(  
                    connectionData.getInputStream(), "UTF-8"));  
            StringBuilder sb = new StringBuilder();  
            String line = null;  
            while ((line = br.readLine()) != null)  
                sb.append(line);  
            String datas = sb.toString();  
            System.out.println(datas);  
            JSONObject jsonData = JSONObject.fromObject(datas);  
            JSONObject info = jsonData.getJSONObject("weatherinfo");  
            map.put("city", info.getString("city").toString());// ����  
            map.put("temp", info.getString("temp").toString());// �¶�  
            map.put("WD", info.getString("WD").toString());// ����  
            map.put("WS", info.getString("WS").toString());// ����  
            map.put("SD", info.getString("SD").toString());// ʪ��  
            map.put("time", info.getString("time").toString());// ����ʱ��  
  
        } catch (SocketTimeoutException e) {  
            System.out.println("���ӳ�ʱ");  
        } catch (FileNotFoundException e) {  
            System.out.println("�����ļ�����");  
        }  
  
        return map;  
  
    }  
      
      
    /** 
     *  
     * ��ȡʵʱ����2<br> 
     * �� �� ���� getTodayWeather <br> 
     *  
     * @param Cityid 
     *            ���б��� 
     */  
    public static Map<String, Object> getTodayWeather2(String Cityid)  
            throws IOException, NullPointerException {  
        // ������������̨��API  
        URL url = new URL("http://www.weather.com.cn/data/cityinfo/" + Cityid  
                + ".html");  
        URLConnection connectionData = url.openConnection();  
        connectionData.setConnectTimeout(1000);  
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(  
                    connectionData.getInputStream(), "UTF-8"));  
            StringBuilder sb = new StringBuilder();  
            String line = null;  
            while ((line = br.readLine()) != null)  
                sb.append(line);  
            String datas = sb.toString();  
            System.out.println(datas);  
            JSONObject jsonData = JSONObject.fromObject(datas);  
            JSONObject info = jsonData.getJSONObject("weatherinfo");  
            map.put("city", info.getString("city").toString());// ����  
            map.put("temp1", info.getString("temp1").toString());// ����¶�  
            map.put("temp2", info.getString("temp2").toString());// ����¶�  
            map.put("weather", info.getString("weather").toString());//����  
            map.put("ptime", info.getString("ptime").toString());// ����ʱ��  
  
        } catch (SocketTimeoutException e) {  
            System.out.println("���ӳ�ʱ");  
        } catch (FileNotFoundException e) {  
            System.out.println("�����ļ�����");  
        }  
  
        return map;  
  
    }  
  
    private static String getWeek(int iw) {  
        String weekStr = "";  
        switch (iw) {  
        case 1:  
            weekStr = "������";  
            break;  
        case 2:  
            weekStr = "����һ";  
            break;  
        case 3:  
            weekStr = "���ڶ�";  
            break;  
        case 4:  
            weekStr = "������";  
            break;  
        case 5:  
            weekStr = "������";  
            break;  
        case 6:  
            weekStr = "������";  
            break;  
        case 7:  
            weekStr = "������";  
            break;  
        default:  
            break;  
        }  
        return weekStr;  
    }  
    
    
    
  

    
    public static void main(String[] args) {  
        try {  
            //���Ի�ȡʵʱ����1(���������ʪ��)  
            Map<String, Object> map = getTodayWeather1("101010100");  
            System.out.println(map.get("city") + "\t" + map.get("temp")  
                    + "\t" + map.get("WD") + "\t" + map.get("WS")  
                    + "\t" + map.get("SD") + "\t" + map.get("time"));  
              
            //���Ի�ȡʵʱ����2(�����������¶ȷ�Χ)  
            Map<String, Object> map2 = getTodayWeather2("101010100");  
            System.out.println(map2.get("city") + "\t" + map2.get("temp1")  
                    + "\t" + map2.get("temp2") + "\t" + map2.get("weather")  
                    + "\t" + map2.get("ptime"));  
              
            //���Ի�ȡһ������  
            List<Map<String, Object>> listData = getWeekWeatherMap("101010100");  
            for (int j = 0; j < listData.size(); j++) {  
                Map<String, Object> wMap = listData.get(j);  
                System.out.println(wMap.get("city") + "\t" + wMap.get("date_y")  
                        + "\t" + wMap.get("week") + "\t" + wMap.get("weather")  
                        + "\t" + wMap.get("temp") + "\t" + wMap.get("wind")  
                        + "\t" + wMap.get("fl"));  
            }  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    
    
    
} 
