/**2012-4-23**/

package com.cq.countline;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-4-23 陈强新建
 */
public class FileInfo {
    
    private String fileName;
    
    private String filePath;
    
    private long characterNum;
    
    private long num;
    
    private long blankNum;
    
    private long lineNum;
    
    /**
     * @return 获取 fileName属性值
     */
    public String getFileName() {
        return fileName;
    }
    
    /**
     * @param fileName 设置 fileName 属性值为参数值 fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * @return 获取 filePath属性值
     */
    public String getFilePath() {
        return filePath;
    }
    
    /**
     * @param filePath 设置 filePath 属性值为参数值 filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * @return 获取 characterNum属性值
     */
    public long getCharacterNum() {
        return characterNum;
    }
    
    /**
     * @param characterNum 设置 characterNum 属性值为参数值 characterNum
     */
    public void setCharacterNum(long characterNum) {
        this.characterNum = characterNum;
    }
    
    /**
     * @return 获取 blankNum属性值
     */
    public long getBlankNum() {
        return blankNum;
    }
    
    /**
     * @param blankNum 设置 blankNum 属性值为参数值 blankNum
     */
    public void setBlankNum(long blankNum) {
        this.blankNum = blankNum;
    }
    
    /**
     * @return 获取 lineNum属性值
     */
    public long getLineNum() {
        return lineNum;
    }
    
    /**
     * @param lineNum 设置 lineNum 属性值为参数值 lineNum
     */
    public void setLineNum(long lineNum) {
        this.lineNum = lineNum;
    }
    
    /**
     * @param num 设置 num 属性值为参数值 num
     */
    public void setNum(long num) {
        this.num = num;
    }
    
    /**
     * @return 获取 num属性值
     */
    public long getNum() {
        return num;
    }
    
    @Override
    public String toString() {
        return "文件：" + fileName + ",字母数：" + this.characterNum + ",数字数目：" + this.num + ",空格数目：" + this.blankNum + "，行数："
            + this.lineNum;
        
    }
    
}
