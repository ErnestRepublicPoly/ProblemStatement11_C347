package sg.edu.rp.c346.problemstatement;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VaccinationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VaccinationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VaccinationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VaccinationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VaccinationFragment newInstance(String param1, String param2) {
        VaccinationFragment fragment = new VaccinationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_vaccination, container, false);

        FloatingActionButton fab = root.findViewById(R.id.fabVac);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action
            }
        });

        Button edit = root.findViewById(R.id.buttonEditVac);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText vac = new EditText(getContext());
                final AlertDialog.Builder editDialog = new AlertDialog.Builder(getContext());
                editDialog.setTitle("Edit Vaccination");
                editDialog.setView(vac);

                editDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String text = vac.getText().toString();
                        TextView tvVac = root.findViewById(R.id.textViewVac);
                        tvVac.setText(text);
                    }
                });
                editDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                editDialog.create().show();
            }
        });

        return root;
    }
}