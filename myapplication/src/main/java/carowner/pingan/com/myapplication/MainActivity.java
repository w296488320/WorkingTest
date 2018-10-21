package carowner.pingan.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private EditText mEt_text;
    private Button mBt_jiami;
    private Button mBt_jiemi;
    private TextView mTv_resut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String str= encode("巅峰时代","cqmygysdss");

        mEt_text = (EditText)findViewById(R.id.et_text);



        mBt_jiami = (Button)findViewById(R.id.bt_jiami);
        mBt_jiemi = (Button)findViewById(R.id.bt_jiemi);



        mBt_jiami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = mEt_text.getText().toString().trim();
                if(!trim.equals("")){
                    mTv_resut.setText(encode(trim,"cqmygysdss"));
                }
            }
        });
        mBt_jiemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = mEt_text.getText().toString().trim();
                if(!trim.equals("")){
                    mTv_resut.setText(jiemi(trim));
                }
            }
        });


        mTv_resut = (TextView)findViewById(R.id.tv_resut);



    }



    public static String jiemi(String str) {
        String decode =decode(str, "cqmygysdss");
        return decode.contains("\u5dc5\u5cf0\u65f6\u4ee3") ? "\u5fae\u79d2\u8f6c" : decode;
    }


    public static String decode(String str, String str2) {
        try {
            return new String(xor(Base64.decode(str, 2), str2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(xor(Base64.decode(str, 2), str2));
        }
    }



    public static String encode(String str, String str2) {
        try {
            return new String(Base64.encode(xor(str.getBytes("UTF-8"), str2), 2));
        } catch (UnsupportedEncodingException e) {
            return new String(Base64.encode(xor(str.getBytes(), str2), 2));
        }
    }

    private static byte[] xor(byte[] bArr, String str) {
        int length = bArr.length;
        int length2 = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (i2 >= length2) {
                i2 = 0;
            }
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i2));
            i++;
            i2++;
        }
        return bArr;
    }


}
