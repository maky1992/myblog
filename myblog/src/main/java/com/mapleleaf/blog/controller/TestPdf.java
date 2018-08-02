package com.mapleleaf.blog.controller;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class TestPdf {

    Document document = null;// 建立一个Document对象      
    private static Font headFont ;
    private static Font keyFont ;
    private static Font textfont_H ;
    private static Font textfont_B ;
    private static Font textfont_K;
    int maxWidth = 520;

    static{    
        BaseFont bfChinese_H;
        try {    
            /** 
             * 新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀 
             * UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H 代表文字版式是 横版， 相应的 V 代表竖版  
             */
            bfChinese_H = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);    

            headFont = new Font(bfChinese_H, 10, Font.NORMAL);   
            keyFont = new Font(bfChinese_H, 18, Font.BOLD); 
            textfont_K = new Font(bfChinese_H, 8, Font.NORMAL);
            textfont_H = new Font(bfChinese_H, 10, Font.NORMAL); 
            textfont_B = new Font(bfChinese_H, 12, Font.NORMAL); 

        } catch (Exception e) {             
            e.printStackTrace();    
        }     
    }

    /**
     * 设置页面属性
     * @param file
     * @return 
     */
    public TestPdf(File file) {

        //自定义纸张
        Rectangle rectPageSize = new Rectangle(595, 842);

        // 定义A4页面大小
        //Rectangle rectPageSize = new Rectangle(PageSize.A4);  
        rectPageSize = rectPageSize.rotate();// 加上这句可以实现页面的横置
        document = new Document(rectPageSize,60, 100, 10, 40);

        try {
            PdfWriter.getInstance(document,new FileOutputStream(file));    
            document.open();
            document.newPage();
        } catch (Exception e) {
            e.printStackTrace();    
        }
    }

    /**
     * 建表格(以列的数量建)
     * @param colNumber
     * @return
     */
    public PdfPTable createTable(int colNumber){    
        PdfPTable table = new PdfPTable(colNumber);    
        try{    
            //table.setTotalWidth(maxWidth);    
            //table.setLockedWidth(true);    
            table.setHorizontalAlignment(Element.ALIGN_CENTER);         
            table.getDefaultCell().setBorder(1); 
            table.setSpacingBefore(10);
            table.setWidthPercentage(100);
        }catch(Exception e){    
            e.printStackTrace();    
        }    
        return table;
    }

    /**
     * 建表格(以列的宽度比建)
     * @param widths
     * @return
     */
    public PdfPTable createTable(float[] widths){    
        PdfPTable table = new PdfPTable(widths);    
        try{    
            //table.setTotalWidth(maxWidth);    
            //table.setLockedWidth(true);    
            table.setHorizontalAlignment(Element.ALIGN_CENTER);         
            table.getDefaultCell().setBorder(1); 
            table.setSpacingBefore(10);
            table.setWidthPercentage(100);
        }catch(Exception e){    
            e.printStackTrace();    
        }    
        return table;    
    }


    /**
     * 表格中单元格
     * @param value
     * @param font
     * @param align
     * @return
     */
    public PdfPCell createCell(String value,Font font,int align){    
        PdfPCell cell = new PdfPCell();    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);            
        cell.setHorizontalAlignment(align);        
        cell.setPhrase(new Phrase(value,font)); 
        return cell;    
    }

    /**
     * 表格中单元格
     * @param value
     * @param font
     * @param align
     * @param colspan
     * @param rowspan
     * @return
     */
    public PdfPCell createCell(String value,Font font,int align_v,int align_h,int colspan,int rowspan){
        PdfPCell cell = new PdfPCell();    
        cell.setVerticalAlignment(align_v);    
        cell.setHorizontalAlignment(align_h);        
        cell.setColspan(colspan); 
        cell.setRowspan(rowspan); 
        cell.setPhrase(new Phrase(value,font));  
        return cell;
    }

    /**
     * 建短语
     * @param value
     * @param font
     * @return
     */
    public Phrase createPhrase(String value,Font font){ 
        Phrase phrase = new Phrase();
        phrase.add(value);
        phrase.setFont(font);
        return phrase;
    }  

    /**
     * 建段落
     * @param value
     * @param font
     * @param align
     * @return
     */
    public Paragraph createParagraph(String value,Font font,int align, float fixedLeading){ 
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Phrase(value,font));
        paragraph.setAlignment(align);
        paragraph.setLeading(fixedLeading);
        return paragraph;
    }
    
    /**
     * 添加图片
     * @param document
     */
    private void createPic(Document document) {  
        String headPicture = "D://PDF//edraftlogo.gif";  
        try {  
            Image image = Image.getInstance(headPicture);  
            //float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();  
            //float documentHeight = documentWidth / 200 * 40;//重新设置宽高  
            image.scaleAbsolute(200, 40);//重新设置宽高  
            document.add(image);  
        } catch (Exception ex) {  
      
        }  
    } 
    
    /**
     * 添加背景图片
     * @param document
     */
    private void createBackgroundPic(Document document) {  
        String headPicture = "D://PDF//edraftgb.jpg";  
        try {  
            Image image = Image.getInstance(headPicture);  
            image.setAbsolutePosition(0, 0);
            image.scaleAbsolute(1024, 842);//重新设置宽高  
            document.add(image);  
        } catch (Exception ex) {  
      
        }  
    } 


    public void generatePDF() throws Exception{
    	//设置背景图片
    	createBackgroundPic(document);
        //页头信息
        document.add(createParagraph("显示日期：2018-5-21",headFont,Element.ALIGN_LEFT,22f));
        document.add(createParagraph("                ",headFont,Element.ALIGN_LEFT,15f));
        //插入图片
        createPic(document);
        document.add(createParagraph("电子商业承兑汇票",keyFont,Element.ALIGN_CENTER,32f));
        document.add(createParagraph("出 票 日 期 ：2018-5-01                                                                                         "
        		+ "                                                                                                                           "
        		+ "票据状态：提示收票成功",headFont,Element.ALIGN_LEFT,32f));
        document.add(createParagraph("汇票到期日：2018-5-31                                                                                        "
        		+ "                                                                                                                           "
        		+ "票据号码： CBC123456",headFont,Element.ALIGN_LEFT,22f));

        //表格信息
        float[] widths = {4.5f,6.5f,12f,27f,4.5f,6.5f,3f,3f,3f,3f,3f,3f,3f,3f,3f,3f,3f,3f,3f};
        PdfPTable table = createTable(widths);
        

        table.addCell(createCell("出    票    人", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,3)); 
        table.addCell(createCell("全        称", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("收    票    人", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,3));
        table.addCell(createCell("全        称", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,14,1));
        table.addCell(createCell("账        号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("账        号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,14,1));
        table.addCell(createCell("开户银行", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("开户银行", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,14,1));
        
        table.addCell(createCell("出 票 保 证 信 息", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("保证人名称：                                                                                                   "
        		+ "保证人地址：                                                                                      "
        		+ "保证日期：                                            ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,17,1));
        table.addCell(createCell("票    据    金    额", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,2));
        table.addCell(createCell("人名币（大写）", textfont_B, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,5,2));
        table.addCell(createCell("十", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("亿", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("千", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("百", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("十", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("万", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("千", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("百", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("十", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("元", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("角", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("分", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        
        table.addCell(createCell("承  兑  人  信  息", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,2));
        table.addCell(createCell("全                    称", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("开  户  行  行  号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,13,1));
        table.addCell(createCell("账                    号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell(" ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("开  户  行  行  号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,13,1));
        
        table.addCell(createCell("交  易  合  同  号", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("承    兑    人    信    息", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,3));
        table.addCell(createCell("出票人承诺：本汇票请予以承兑，到期无条件付款", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,14,1));
        table.addCell(createCell("能    否    转    让", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,2));
        table.addCell(createCell("", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,2));
        table.addCell(createCell("承兑人承诺：本汇票已经承兑，到期无条件付款                                                                                                         "
        		+ "                                                        承兑日期：", 
        		textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,14,2));
        
        table.addCell(createCell("承 兑 保 证 信 息", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("保证人名称：                                                                                                   "
        		+ "保证人地址：                                                                                      "
        		+ "保证日期：                                            ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,17,1));
        
        table.addCell(createCell("评级信息（由出票人、承兑人自己记载，仅供参考）", textfont_K, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,2));
        table.addCell(createCell("出      票     人", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("评级主体：                                                                                "
        		+ "信用等级：                                                                          "
        		+ "评级到期日：                                  ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,16,1));
        table.addCell(createCell("承     兑     人", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(createCell("评级主体：                                                                                "
        		+ "信用等级：                                                                          "
        		+ "评级到期日：                                  ", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,16,1));
        
        
        document.add(table); 
        document.newPage();
      //设置背景图片
    	createBackgroundPic(document);
        //页头信息
        document.add(createParagraph("显示日期：2018-5-21",headFont,Element.ALIGN_LEFT,22f));
        document.add(createParagraph("                ",headFont,Element.ALIGN_LEFT,15f));
        //插入图片
        createPic(document);
        document.add(createParagraph("电子商业承兑汇票",keyFont,Element.ALIGN_CENTER,32f));
        document.add(createParagraph("票据号码：DBC4138749287483",headFont,Element.ALIGN_LEFT,32f));
        //表格信息
        float[] width = {33f,67f};
        PdfPTable tables = createTable(width);
        tables.addCell(createCell("转让背书", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        
        tables.addCell(createCell("背书人名称", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        tables.addCell(createCell("二虎", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        tables.addCell(createCell("被背书人名称", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        tables.addCell(createCell("傻蛋", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        tables.addCell(createCell("不得转让标记", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        tables.addCell(createCell("是", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        tables.addCell(createCell("背书日期", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        tables.addCell(createCell("2018-05-22", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        document.add(tables); 
        document.close();    
    }

    public static void main(String[] args) throws Exception {
        File file = new File("d:\\PDF\\T3.pdf");

        file.createNewFile();
        new TestPdf(file).generatePDF(); 
    }
}
