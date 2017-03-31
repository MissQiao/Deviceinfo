package info.hct.com.deviceinfo;

import android.Manifest;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;

public class MainActivity extends AppCompatActivity {

    private TextView textView ;
    private ImageView save_image ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView() ;

        // String model = DeviceInfo.getDeviceModelInfo();


        final String info =  getDeviceBaseinfo();

        textView .setText( info ) ;

        save_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
                FileUtils.saveStringToFile(info);
            }
        });

        // 先判断是否有权限。
        if(AndPermission.hasPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE )) {
            // 有权限，直接do anything.
        } else {
            // 申请权限。
            AndPermission.with(this)
                    .requestCode(100)
                    .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                    .send();
        }
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        save_image  = (ImageView) findViewById(R.id.imageView);
    }

    /*
    获取手机build.pro信息
     */
    private String getDeviceBaseinfo() {
        String model = "ro.product.model = " + SystemBuildprop.get(this,"ro.product.model");
        String brand = "ro.product.brand =" + SystemBuildprop.get(this,"ro.product.brand");
        String name = "ro.product.name = " + SystemBuildprop.get(this,"ro.product.name");
        String device = "ro.product.device = " + SystemBuildprop.get(this,"ro.product.device");
        String manufacturer = "ro.product.manufacturer = " + SystemBuildprop.get(this,"ro.product.manufacturer");
        String description = "ro.build.description = " + SystemBuildprop.get(this,"ro.build.description");
        String fingerprint = "ro.build.fingerprint = " + SystemBuildprop.get(this,"ro.build.fingerprint");
        String date_utc = "ro.build.date.utc = " + SystemBuildprop.get(this,"ro.build.date.utc");
        String date = "ro.build.date = " + SystemBuildprop.get(this,"ro.build.date");
        String id= "ro.build.id = " + SystemBuildprop.get(this,"ro.build.id");
        String display_id = "ro.build.display.id = " + SystemBuildprop.get(this,"ro.build.display.id");
        String version_incremental = "ro.build.version.incremental = " +
                SystemBuildprop.get(this,"ro.build.version.incremental");
        String tags = "ro.build.tags = "+ SystemBuildprop.get(this,"ro.build.tags");


        String deviceInfo = model + "\n" +
                brand + "\n" +
                name + "\n" +
                device + "\n" +
                manufacturer + "\n" +
                description + "\n" +
                fingerprint + "\n" +
                date_utc + "\n" +
                date + "\n" +
                id + "\n" +
                display_id + "\n" +
                version_incremental + "\n"+
                tags + "\n";

        return deviceInfo;



    }
}
