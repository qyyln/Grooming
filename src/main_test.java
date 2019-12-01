import java.util.ArrayList;
import java.util.HashMap;

public class main_test {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
		mainLian m = new mainLian();
		
		m.init();
		System.out.println("test transponderSearch");
		m.transponderSearch(0);
		for(ArrayList<String> tmp : m.getNode_st_list()){
			for(String s: tmp)
				System.out.print(tmp);
		}
		System.out.println();
		System.out.println();

		m.init();
		m.transponderTake(1,0);
		System.out.println("test transponderTake");
		m.transponderTake(1,0);
		System.out.print(m.getNode_st_list());
		System.out.println();
		System.out.print(m.getNode_subst_list());
		System.out.println();
		System.out.println();

		m.init();
		System.out.println("test subtransponderTake");
		m.subtransponderTake(1,0,0);
		System.out.print(m.getNode_st_list());
		System.out.println();
		System.out.print(m.getNode_subst_list());
		System.out.println();
		System.out.println();

		m.init();
		System.out.println("test subtransponderTake");
		m.transponderRelease(1,0);
		System.out.print(m.getNode_st_list());
		System.out.println();
		System.out.print(m.getNode_subst_list());
		System.out.println();
		System.out.println();
		
		m.init();
		System.out.println("test subtransponderRelease");
		m.subtransponderTake(1,0,0);
		System.out.print(m.getNode_st_list());
		System.out.println();
		System.out.print(m.getNode_subst_list());
		System.out.println();
		m.subtransponderRelease(1,0,0);
		System.out.print(m.getNode_st_list());
		System.out.println();
		System.out.print(m.getNode_subst_list());
		System.out.println();
		System.out.println();
		
		m.init();
		System.out.println("test subtransponderRelease");
		System.out.print(m.getEdgeSpectrumRes());
		System.out.println();
		ArrayList<Integer> channelset = new ArrayList<>();
		//use channel 0,1,2,3
		channelset.add(0);
		channelset.add(1);
		channelset.add(2);
		channelset.add(3);
		m.spectrumRelease(0, 1, channelset, null);
		System.out.print(m.getEdgeSpectrumRes());
		System.out.println();
		System.out.println();
		
		m.init();
		System.out.println("test spectrumSearch");
		m.spectrumRelease(0, 1, channelset, null);
		m.spectrumSearch(0,1,1, null);
		System.out.print(m.getEdgeSpectrumRes());
		System.out.println();

		
    }
}
