package it.edu.falcone_righi.LibrettoVoti.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Libretto {
	private List<Voto> lv = new ArrayList<>();

	private Errors error=Errors.NOERROR;
	
	public String getErrorMsg() {
		return error.getMsg();
	}

	public int getErrorCode() {
		return error.getCode();
	}

	public boolean add(Voto element) {
		Voto v = get(element.getNomeCorso());
		if (null != v) {
			if (v.equals(element)) {
				// Qualora si voglia attivare la gestione di errore tramite Exception
				// throw new DuplicateElementException("Esame duplicato");
				error = Errors.CONFLICT;
				return false;
			} else {
				// Qualora si voglia attivare la gestione di errore tramite Exception
				// throw new DuplicateElementException("Esame già presente");
				error = Errors.CONFLICT;
			}
		}
		error = Errors.NOERROR;
		return lv.add(element);
	}

	public int size() {
		return lv.size();
	}
	public boolean isEmpty() {
		return lv.isEmpty();
	}

	public boolean contains(Object o) {
		return lv.contains(o);
	}

	public boolean remove(Object o) {
		lv.remove(o);
		return false;
	}

	public Voto get(String corso) {
		Iterator<Voto> i = lv.iterator();
		while (i.hasNext()) {
			Voto v = i.next();
			if (v.getNomeCorso().equalsIgnoreCase(corso))
				return v;
		}
		return null;
	}
	public Voto set(int index, Voto element) {
		return lv.set(index, element);
	}

	public boolean update(Voto element) {
		Voto v = get(element.getNomeCorso());
		if (null != v) {
//		lv.add(lv.indexOf(v), element);
//		v.setDataEsame(element.getDataEsame());
//		v.setVotoOttenuto(element.getVotoOttenuto());
			set(lv.indexOf(v), element);
			return true;
		} else {
			error = Errors.UNEXISTENT;
			return false;
		}
	}

	public void add(int index, Voto element) {
		Voto v = get(element.getNomeCorso());
		if (null != v) {
			if (v.equals(element)) {
				error = Errors.CONFLICT;
				throw new DuplicateElementException("Esame duplicato");
			} else {
				error = Errors.CONFLICT;
				throw new DuplicateElementException("Esame già presente");
			}
		}

		lv.add(index, element);
	}

    public List<Voto>getListaVoti() {
    	return this.lv;
    }
    
	@Override
	public String toString() {
		return "[lv=" + lv + "]";
	}

}
