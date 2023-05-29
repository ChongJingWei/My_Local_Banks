package sg.edu.rp.c346.id22024709.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;
    int fav_dbs = 0;
    int fav_ocbc = 0;
    int fav_uob = 0;
    int el= 1;
    int cl = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

//        tvDBS.setText("DBS");
//        tvOCBC.setText("OCBC");
//        tvUOB.setText("UOB");


        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v,
                                     ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (el == 1){


        if (v.getId() == R.id.tvDBS){
            menu.add(1,0,0,"Website");
            menu.add(1,1,1,"Contact the bank");
            menu.add(1,2,2,"Toggle Favourite");
        } else if (v.getId() == R.id.tvOCBC) {
            menu.add(2,0,0,"Website");
            menu.add(2,1,1,"Contact the bank");
            menu.add(2,2,2,"Toggle Favourite");
        } else if (v.getId() == R.id.tvUOB) {
            menu.add(3,0,0,"Website");
            menu.add(3,1,1,"Contact the bank");
            menu.add(3,2,2,"Toggle Favourite");
        }
;     } else if (cl ==1 ){
            if (v.getId() == R.id.tvDBS){
                menu.add(1,0,0,"网站");
                menu.add(1,1,1,"联系银行");
                menu.add(1,2,2,"切换最爱");
            } else if (v.getId() == R.id.tvOCBC) {
                menu.add(2,0,0,"网站");
                menu.add(2,1,1,"联系银行");
                menu.add(2,2,2,"切换最爱");
            } else if (v.getId() == R.id.tvUOB) {
                menu.add(3,0,0,"网站");
                menu.add(3,1,1,"联系银行");
                menu.add(3,2,2,"切换最爱");
            }
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {


        if (item.getGroupId()== 1){
                if(item.getItemId()==0){
                    Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbs_web)));
                    startActivity(intent);

                } else if (item.getItemId()==1){
                    Intent intentCall =  new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbs_num)));
                    startActivity(intentCall);
                } else if (item.getItemId()==2){
                    if (fav_dbs == 0){
                        fav_dbs = 1;
                        fav_ocbc = 0;
                        fav_uob = 0;

                        tvDBS.setTextColor(Color.RED);
                        tvOCBC.setTextColor(Color.BLACK);
                        tvUOB.setTextColor(Color.BLACK);
                    } else if (fav_dbs == 1) {
                        fav_dbs = 0;
                        tvDBS.setTextColor(Color.BLACK);

                    }

                }
            }
//        ---------------------------------------------------
        else if (item.getGroupId()== 2){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbc_web)));
                startActivity(intent);

            } else if (item.getItemId()==1){
                Intent intentCall =  new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbc_num)));
                startActivity(intentCall);
            } else if (item.getItemId()==2){
            if (fav_ocbc == 0){
                fav_dbs =  0 ;
                fav_ocbc = 1;
                fav_uob = 0;

                tvDBS.setTextColor(Color.BLACK);
                tvOCBC.setTextColor(Color.RED);
                tvUOB.setTextColor(Color.BLACK);
            } else if (fav_ocbc == 1) {
                fav_ocbc = 0;
                tvOCBC.setTextColor(Color.BLACK);
            }

        }
//            -------------------------------------------------
        }
        else if (item.getGroupId()== 3){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uob_web)));
                startActivity(intent);

            } else if (item.getItemId()==1){
                Intent intentCall =  new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uob_num)));
                startActivity(intentCall);
            } else if (item.getItemId()==2){
                if (fav_uob == 0){
                    fav_dbs =  0 ;
                    fav_ocbc = 0;
                    fav_uob = 1;

                    tvDBS.setTextColor(Color.BLACK);
                    tvOCBC.setTextColor(Color.BLACK);
                    tvUOB.setTextColor(Color.RED);

                } else if (fav_uob == 1) {
                    fav_uob = 0;
                    tvUOB.setTextColor(Color.BLACK);
                }

            }
        }
        else {

        }

        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            el = 1;
            cl = 0;
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText(getString(R.string.dbs_cl));
            tvOCBC.setText(getString(R.string.ocbc_cl));
            tvUOB.setText(getString(R.string.uob_cl));
            el= 0;
            cl= 1;
            return true;
        } else {
            tvDBS.setText("Error in languages");
            tvOCBC.setText("Error in languages");
            tvUOB.setText("Error in languages");
        }

        return super.onOptionsItemSelected(item);
    }

}