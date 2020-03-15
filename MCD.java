import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MCD {

	public static List<Integer> primeFactors(int numbers) {
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
	
	public static int countX(List<Integer> tmp, int x) {
		
		int count = 0;
		for(int i : tmp ) {
			if(i == x)
				count++;
		}
		
		return count;
		
	}
	
	
	public static int getMinValue(List<HashMap<Integer, Integer>> listaFattori, int cerca) {
		
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
	
	public static void main(String[] args) {
		
		int[] a = {456,96, 16, 480};
		Arrays.sort(a);
		for(int i : a)
			System.out.print(i + " , ");
		System.out.println();
		
		List<HashMap<Integer, Integer>> listaFattori = new ArrayList<HashMap<Integer, Integer>>();	
		for(int i = 0; i < a.length; i++) {
			List<Integer> fattori = primeFactors(a[i]);
			HashMap<Integer, Integer> val_fatt = new HashMap<Integer, Integer>();
			for(int x : fattori) {
				val_fatt.put(x, countX(fattori, x));
			}
			listaFattori.add(val_fatt);
		}
		
		System.out.println(listaFattori);
		
		int operation = 1;
		for(int n : listaFattori.get(0).keySet()) {
			if(getMinValue(listaFattori,n) != 0)
				operation *= Math.pow(n,getMinValue(listaFattori,n));
		
		System.out.println("MCD = " + operation);
		
	}
	
}
