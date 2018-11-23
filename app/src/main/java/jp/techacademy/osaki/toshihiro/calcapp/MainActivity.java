package jp.techacademy.osaki.toshihiro.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {


        //if (mEditText1.getText().toString().equals("") || mEditText2.getText().toString().equals("")) {
        //    showAlertDialog1();
        //} else {
            try {
                double dbl1 = Double.parseDouble(mEditText1.getText().toString());
                double dbl2 = Double.parseDouble(mEditText2.getText().toString());
                String ans = "";
                if (v.getId() == R.id.button1) { //＋
                    ans = mEditText1.getText().toString() + "＋" + mEditText2.getText().toString() + "＝" + String.valueOf(dbl1 + dbl2);

                } else if (v.getId() == R.id.button2) {
                    //－
                    ans = mEditText1.getText().toString() + "－" + mEditText2.getText().toString() + "＝" + String.valueOf(dbl1 - dbl2);

                } else if (v.getId() == R.id.button3) {
                    //×
                    ans = mEditText1.getText().toString() + "×" + mEditText2.getText().toString() + "＝" + String.valueOf(dbl1 * dbl2);

                } else if (v.getId() == R.id.button4) {
                    //÷
                    if (dbl2==0){
                        String ttl="<警告>";
                        String msg="ゼロ割エラー";
                        showAlertDialog(ttl,msg);
                        return;
                    }
                    ans = mEditText1.getText().toString() + "÷" + mEditText2.getText().toString() + "＝" + String.valueOf(dbl1 / dbl2);

                }
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("ANS", ans);
                startActivity(intent);
            } catch (Exception e) {
                // 例外情報 e.getMessage()
                String ttl="<注意>";
                String msg="数値を入力してください";
                showAlertDialog(ttl,msg);
            }
        //}
    }

    private void showAlertDialog(String ttl,String msg) {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(ttl);
        alertDialogBuilder.setMessage(msg);

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK", null);

        // AlertDialog1を作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
