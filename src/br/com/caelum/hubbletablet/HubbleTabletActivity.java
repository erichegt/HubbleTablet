package br.com.caelum.hubbletablet;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class HubbleTabletActivity extends Activity  {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		if (!estaNaHorizontal()) {
			getFragmentManager().beginTransaction()
				.replace(R.id.ambos_fragments, new ListaImagensFragment())
				.addToBackStack(null)
			.commit();
		}
    }
	
	public void lidaComASelecaoDaImagem() {
		if (estaNaHorizontal()) {
			ListaImagensFragment listaFragment = (ListaImagensFragment) 
					getFragmentManager().findFragmentById(R.id.fragment1);
			
			ImagemFragment imagemFragment = (ImagemFragment)
					getFragmentManager().findFragmentById(R.id.fragment2);
			
			imagemFragment.setImagem(listaFragment.getImagemSelecionada());
			imagemFragment.atualizaImagem();
			
		} else {
			ListaImagensFragment listaFragment = (ListaImagensFragment)
					getFragmentManager().findFragmentById(R.id.ambos_fragments);
			
			ImagemFragment imagemFragment = new ImagemFragment();
			imagemFragment.setImagem(listaFragment.getImagemSelecionada());
			
			getFragmentManager()
				.beginTransaction()
					.replace(R.id.ambos_fragments, imagemFragment)
					.addToBackStack(null)
				.commit();
		}
	}
	
	private boolean estaNaHorizontal() {
		return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
				& getResources().getConfiguration().isLayoutSizeAtLeast(
						Configuration.SCREENLAYOUT_SIZE_XLARGE);
	}
}