import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MCD {

	public List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
	
	public int countX(List<Integer> tmp, int x) {
		
		int count = 0;
		for(int i : tmp ) {
			if(i == x)
				count++;
		}
		
		return count;
		
	}
	
	public int getMinValue(List<HashMap<Integer, Integer>> listaFattori, int cerca) {
		
		int valore = Integer.MAX_VALUE;
		for(int i = 0; i < listaFattori.size(); i++) {
			if(listaFattori.get(i).containsKey(cerca)) {
				if(listaFattori.get(i).get(cerca) < valore)
					valore = listaFattori.get(i).get(cerca);
			}else {
				valore = 0;
				break;
			}
		}
		
		return valore;
		
	}
	
	public int getMaxValue(List<HashMap<Integer, Integer>> listaFattori, int cerca) {
		
		int valore = 0;
		for(int i = 0; i < listaFattori.size(); i++) {
			if(listaFattori.get(i).containsKey(cerca)) {
				if(listaFattori.get(i).get(cerca) > valore)
					valore = listaFattori.get(i).get(cerca);
			}
		}
		
		return valore;
		
	}
	
	public int get_MCM(int[] a) {
		Arrays.sort(a);
		
		List<HashMap<Integer, Integer>> listaFattori = new ArrayList<HashMap<Integer, Integer>>();	
		for(int i = 0; i < a.length; i++) {
			List<Integer> fattori = primeFactors(a[i]);
			HashMap<Integer, Integer> val_fatt = new HashMap<Integer, Integer>();
			for(int x : fattori) {
				val_fatt.put(x, countX(fattori, x));
			}
			listaFattori.add(val_fatt);
		}
		
		int operation = 1;
		ArrayList<Integer> cercati = new ArrayList<Integer>();
		for(int i = 0; i < listaFattori.size(); i++) {
			for(int n : listaFattori.get(i).keySet()) {
				if(!cercati.contains(n)) {
					if(getMaxValue(listaFattori,n) != 0)
						operation *= Math.pow(n,getMaxValue(listaFattori,n));
					cercati.add(n);
				}

			}
			
		}
		
		return operation;
	}
	
	public int get_MCD(int[] a) {
		
		Arrays.sort(a);
		
		List<HashMap<Integer, Integer>> listaFattori = new ArrayList<HashMap<Integer, Integer>>();	
		for(int i = 0; i < a.length; i++) {
			List<Integer> fattori = primeFactors(a[i]);
			HashMap<Integer, Integer> val_fatt = new HashMap<Integer, Integer>();
			for(int x : fattori) {
				val_fatt.put(x, countX(fattori, x));
			}
			listaFattori.add(val_fatt);
		}
		
		int operation = 1;
		for(int n : listaFattori.get(0).keySet()) {
			if(getMinValue(listaFattori,n) != 0)
				operation *= Math.pow(n,getMinValue(listaFattori,n));
		}
		
		return operation;
	}
	
	
}
