package br.com.caelum.hubbletablet;

import java.io.IOException;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaImagensFragment extends Fragment {
	private String imagemSelecionada;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View viewLista = inflater.inflate(R.layout.lista, null);
		
		ListView listaImagens = (ListView) viewLista.findViewById(R.id.listaImagens);
		colocaDadosNoListView(listaImagens);

		listaImagens.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
				imagemSelecionada = "hubble/"+ (String) adapterView.getItemAtPosition(posicao);
				HubbleTabletActivity activity = (HubbleTabletActivity) getActivity();
				activity.lidaComASelecaoDaImagem();
			}
		});

		return viewLista;
	}

	private void colocaDadosNoListView(ListView listView) {
		
		String[] listImagens = null;
		try {
			listImagens = getActivity().getAssets().list("hubble");
		} catch (IOException e) {
			listImagens = new String[]{};
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, listImagens);

		listView.setAdapter(adapter);
	}
	
	public String getImagemSelecionada() {
		return imagemSelecionada;
	}

}
