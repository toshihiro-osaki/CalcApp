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
        button1.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {

        double dbl1 = Double.parseDouble(mEditText1.getText().toString());
        double dbl2 = Double.parseDouble(mEditText2.getText().toString());
        String ans = "";

        if (mEditText1.getText().toString() == "" || mEditText2.getText().toString() == "") {
            showAlertDialog1();
        } else {
            try {
                if (v.getId() == R.id.button1) {
                    //＋
                    ans = mEditText1.getText().toString() + "＋" + mEditText2.getText().toString() + "＝" + String.valueOf(dbl1 + dbl2);
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("ANS", ans);
                    startActivity(intent);

                } else if (v.getId() == R.id.button2) {
                    //－
                    ans = mEditText1.getText().toString() + "－" + mEditText2.getText().toString() + "＝" + String.valueOf(dbl1 - dbl2);
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("ANS", ans);
                    startActivity(intent);

                } else if (v.getId() == R.id.button3) {
                    //×
                    ans = mEditText1.getText().toString() + "×" + mEditText2.getText().toString() + "＝" + String.valueOf(dbl1 * dbl2);
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("ANS", ans);
                    startActivity(intent);

                } else if (v.getId() == R.id.button4) {
                    //÷
                    ans = mEditText1.getText().toString() + "÷" + mEditText2.getText().toString() + "＝" + String.valueOf(dbl1 / dbl2);
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("ANS", ans);
                    startActivity(intent);

                }
            } catch (Exception e) {
                // 例外情報 e.getMessage()
                showAlertDialog2();
            }

        }

    }

    private void showAlertDialog1() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("タイトル:注意");
        alertDialogBuilder.setMessage("メッセージ：数字を入力してください。");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK", null);

        // AlertDialog1を作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void showAlertDialog2() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("タイトル:警告");
        alertDialogBuilder.setMessage("メッセージ：ゼロ割エラー");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK", null);

        // AlertDialog2を作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
