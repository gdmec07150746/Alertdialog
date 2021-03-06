package s07150746.alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static s07150746.alertdialog.R.id.button7;

public class MainActivity extends AppCompatActivity {
        private AlertDialog dialog;
        private  AlertDialog.Builder builder;
    private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView=(TextView)findViewById(R.id.textView);
        Button btn1=(Button)findViewById(R.id.button1);
        Button btn2=(Button)findViewById(R.id.button2);
        Button btn3=(Button)findViewById(R.id.button3);
        Button btn4=(Button)findViewById(R.id.button4);
        Button btn5=(Button)findViewById(R.id.button5);
        Button btn6=(Button)findViewById(R.id.button6);
        Button btn7=(Button)findViewById(button7);
        View.OnClickListener listener=new View.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case button7:
                        dialog7();
                        break;

                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }




    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("两个按钮");
        dialog.setMessage("确认退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        //创建按键监听
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                if(which==DialogInterface.BUTTON_POSITIVE){//按下确定
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){//按下取消
                    dialog.dismiss();
                  }
              }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"確定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",listener);
        dialog.show();
    }
    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("三個按钮");
        dialog.setMessage("你喜歡我吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        //創建按鍵監聽
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="很喜歡";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="真的好喜歡";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="超級喜歡！";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"喜歡",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"超級喜歡",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"好喜歡",listener);
        dialog.show();
    }
        public void dialog3(){
            dialog=new AlertDialog.Builder(this).create();
            dialog.setTitle("请输入");
            dialog.setMessage("你平时忙么？");
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            final EditText tEdit=new EditText(this);
            dialog.setView(tEdit);
            //创建按键监听器
            DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tView.setText("输入的是："+tEdit.getText().toString());
                }
            };
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
            dialog.show();
        }
            public void dialog4(){
                final String item[]=new String[]{"广州","北京","上海"};
                final boolean bSelect[]=new boolean[item.length];
                DialogInterface.OnMultiChoiceClickListener mListener=new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //用一个数组记录下选择的所有选项
                        bSelect[which]=isChecked;
                    }
                };
                builder =new AlertDialog.Builder(this);
                builder.setMultiChoiceItems(item,null,mListener);
                dialog=builder.create();
                dialog.setTitle("复选框");
                DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str="你选择了：";
                        for (int i=0;i<bSelect.length;i++){
                            if(bSelect[i]){
                                str=str+"\n"+item[i];

                            }
                        }
                        tView.setText(str);
                    }
                };
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
                dialog.show();}

        public void dialog5(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;

            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListener);
            dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
                public void dialog6(){
                    final String item[]=new String[]{"北京","上海","广州"};
                    final boolean bSelect[]=new boolean[item.length];
                    DialogInterface.OnClickListener sListener=new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String str="你选择了："+item[which];
                            tView.setText(str);
                        }
                    };
                    builder= new AlertDialog.Builder(this);
                    builder.setItems(item,sListener);
                    dialog=builder.create();
                    dialog.setTitle("列表框");
                    DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    };
                    dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
                    dialog.show();

                }
    public void dialog7(){
        LayoutInflater inflater=getLayoutInflater();
        View layout =inflater.inflate(R.layout.layout,null);
        final EditText tEdit=(EditText)layout.findViewById(button7);
        dialog =new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
}






