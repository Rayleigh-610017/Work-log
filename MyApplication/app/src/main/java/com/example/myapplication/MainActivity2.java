package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 1. 前の画面から送られてきたインテントを受け取る
        Intent intent = getIntent();
        String workerName = intent.getStringExtra("WORKER_NAME");
        boolean isEquipmentChecked = intent.getBooleanExtra("EQUIPMENT_CHECK", false);
        boolean isSafetyChecked = intent.getBooleanExtra("SAFETY_CHECK", false);
        String shift = intent.getStringExtra("SHIFT");
        String process = intent.getStringExtra("PROCESS");
        String workDetail = intent.getStringExtra("WORK_DETAIL");

        // 2. 表示用のテキストを作成
        String displayMessage = "【作業者名】\n" + workerName + "\n\n" +
                "【設備点検】\n" + (isEquipmentChecked ? "チェックあり" : "なし") + "\n\n" +
                "【安全点検】\n" + (isSafetyChecked ? "チェックあり" : "なし") + "\n\n" +
                "【勤務シフト】\n" + shift + "\n\n" +
                "【工程】\n" + process + "\n\n" +
                "【作業詳細】\n" + workDetail;

        // 3. プレビュー用のTextViewに流し込む
        TextView tvPreviewContent = findViewById(R.id.tvPreviewContent);
        tvPreviewContent.setText(displayMessage);

        // 4. 保存ボタンの処理
        Button btnConfirmSave = findViewById(R.id.btnConfirmSave);
        btnConfirmSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "保存しました！", Toast.LENGTH_SHORT).show();
                // 必要に応じて画面を閉じる、または元の画面に戻る処理
                finish();
            }
        });
    }
}