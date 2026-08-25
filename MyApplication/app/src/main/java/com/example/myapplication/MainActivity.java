package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 送信ボタンの取得
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // ボタンクリック時の処理（Java 11対応）
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2. 各パーツから入力・選択された値を取得する

                // ① 作業者名（EditText）
                EditText etWorkerName = findViewById(R.id.etWorkerName);
                String workerName = etWorkerName.getText().toString();

                // ② 設備点検（CheckBox）
                CheckBox cbEquipmentCheck = findViewById(R.id.cbEquipmentCheck);
                boolean isEquipmentChecked = cbEquipmentCheck.isChecked();

                // ③ 安全点検（CheckBox）
                CheckBox cbSafetyCheck = findViewById(R.id.cbSafetyCheck);
                boolean isSafetyChecked = cbSafetyCheck.isChecked();

                // ④ 勤務シフト（RadioGroup / RadioButton）
                RadioGroup rgShift = findViewById(R.id.rgShift);
                int selectedShiftId = rgShift.getCheckedRadioButtonId();
                String shiftName = "";
                if (selectedShiftId != -1) {
                    RadioButton rbSelectedShift = findViewById(selectedShiftId);
                    shiftName = rbSelectedShift.getText().toString();
                }

                // ⑤ 工程（Spinner）
                Spinner spProcess = findViewById(R.id.spProcess);
                String selectedProcess = spProcess.getSelectedItem().toString();

                // ⑥ 作業詳細（EditText）
                EditText etWorkDetail = findViewById(R.id.etWorkDetail);
                String workDetail = etWorkDetail.getText().toString();

                // 3. プレビュー画面（MainActivity2）へデータを渡して画面遷移する
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("WORKER_NAME", workerName);
                intent.putExtra("EQUIPMENT_CHECK", isEquipmentChecked);
                intent.putExtra("SAFETY_CHECK", isSafetyChecked);
                intent.putExtra("SHIFT", shiftName);
                intent.putExtra("PROCESS", selectedProcess);
                intent.putExtra("WORK_DETAIL", workDetail);

                startActivity(intent);
            }
        });
    }
}