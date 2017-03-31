package info.hct.com.deviceinfo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // String model = DeviceInfo.getDeviceModelInfo();


       final String info =  getDeviceBaseinfo();

        getView(info);
        ImageView i = (ImageView) findViewById(R.id.imageView);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
                FileUtils.saveStringToFile(info);
            }
        });

        //System.out.print(model);
    }

    private void getView(String textDeviceInfo) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(textDeviceInfo);
       // EditText editText = (EditText) findViewById(R.id.editText);
       // editText.setText(textDeviceInfo);

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
