package br.senac.go.projetoandroid.data.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.projetoandroid.R;
import br.senac.go.projetoandroid.data.model.Abastecimento;


public class ListaAbastecimentoAdapter extends RecyclerView.Adapter<ListaAbastecimentoAdapter.ViewHolder> {
    private final List<Abastecimento> abastecimentoList;
    private final LayoutInflater layoutInflater;

    public ListaAbastecimentoAdapter(List<Abastecimento> abastecimentoList, LayoutInflater layoutInflater) {
        this.abastecimentoList = abastecimentoList;
        this.layoutInflater = layoutInflater;
    }


    @NonNull
    @Override
    public ListaAbastecimentoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.activity_abastecimentos_view, parent, false));
    }



    @Override
    public void onBindViewHolder(@NonNull ListaAbastecimentoAdapter.ViewHolder holder, int position) {
        holder.bind(abastecimentoList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return abastecimentoList.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        public void bind(Abastecimento abastecimento, int position) {
            textView.setText(abastecimento.getId() + " " + abastecimento.getData() + " " + abastecimento.getOdometro() + " " + abastecimento.getTotlitros() + " " + abastecimento.getValor_unit());

        }
    }
}
