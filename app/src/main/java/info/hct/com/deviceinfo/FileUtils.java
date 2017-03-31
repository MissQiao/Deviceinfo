package info.hct.com.deviceinfo;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by root on 17-3-31.
 */
public class FileUtils {

    public static final String FILE_NAME  = "jiamao.txt" ; //文件名称

    /**
     * 保存字符串到文件
     * @param data
     */
    public static void saveStringToFile( String data ){
        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() ; //获取SD卡根目录
        File file = new File( rootPath + File.separator + FILE_NAME ) ;

        FileOutputStream fileOutputStream = null ;

        try {
            byte[] array = data.getBytes() ; //把string转换为byte数组；
            fileOutputStream = new FileOutputStream( file ) ; //创建输出流
            fileOutputStream.write( array ) ;  //把内容写入文件
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {

            //关闭输出流
            if ( fileOutputStream != null ){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
