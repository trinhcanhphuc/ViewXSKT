package com.example.trinhcanhphuc.viewxskt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListNumTTFragment extends Fragment {

    TextView txtNumTT;
    TongDai tongDai;
    int numDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        numDay = getArguments().getInt("numDay");
        tongDai = (TongDai) getArguments().getSerializable("info");
        String prize = "1\t: ";

        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getFirst_prize().size() ; i++){
            prize += "\t" +  tongDai.getKqsxDays().get(numDay).getFirst_prize().get(i) + "\t";
        }
        prize += "\n2\t: ";
        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getSecond_prize().size() ; i++){
            prize += "\t" + tongDai.getKqsxDays().get(numDay).getSecond_prize().get(i) + "\t";
        }
        prize += "\n3\t: ";
        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getThird_prize().size() ; i++){
            prize += "\t" + tongDai.getKqsxDays().get(numDay).getThird_prize().get(i) + "\t";
        }
        prize += "\n4\t: ";
        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getFourth_prize().size() ; i++){
            prize +=  "\t" + tongDai.getKqsxDays().get(numDay).getFourth_prize().get(i) + "\t";
        }
        prize += "\n5\t: ";
        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getFifth_prize().size() ; i++){
            prize +=  "\t" + tongDai.getKqsxDays().get(numDay).getFifth_prize().get(i) + "\t";
        }
        prize += "\n6\t: ";
        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getSixth_prize().size() ; i++){
            prize +=  "\t" + tongDai.getKqsxDays().get(numDay).getSixth_prize().get(i) + "\t";
        }
        prize += "\n7\t: ";
        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getSeventh_prize().size() ; i++){
            prize +=  "\t" + tongDai.getKqsxDays().get(numDay).getSeventh_prize().get(i) + "\t";
        }
        prize += "\n8\t: ";
        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getEighth_prize().size() ; i++){
            prize +=  "\t" + tongDai.getKqsxDays().get(numDay).getEighth_prize().get(i) + "\t";
        }
        prize += "\nDB\t: ";
        for(int i = 0 ; i < tongDai.getKqsxDays().get(numDay).getSpecial_prize().size() ; i++){
            prize +=  "\t" + tongDai.getKqsxDays().get(numDay).getSpecial_prize().get(i) + "\t";
        }
        prize += "\n";

        View view = inflater.inflate(R.layout.fragment_list_num_tt, container, false);
        txtNumTT = (TextView) view.findViewById(R.id.txtNumTT);
        txtNumTT.setText("=> " + String.valueOf(tongDai.getKqsxDays().get(numDay).getDate()) + "\n\n" + prize);
        txtNumTT.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        return view;
    }
}