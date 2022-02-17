package _01_Spies_On_A_Train;

import java.util.ArrayList;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	ArrayList <String> names = new ArrayList ();
    	ArrayList <Integer> matches = new ArrayList ();
    	for (int i = 0; i < clues.length; i++) {
    		System.out.println(clues[i]);
		}
    	Node name = train.getHead();
    	for (int i = 0; i < train.size();i++) {
    		String evidence = ((TrainCar)name.getValue()).questionPassenger();
    		int questionMark = evidence.indexOf("?");
    		evidence = evidence.substring(questionMark);
    		evidence = evidence.substring(8);
    		evidence = evidence.substring(0, evidence.indexOf(" "));
    		if (!names.contains (evidence)) {
    			names.add(evidence);
    			matches.add(0);
    			System.out.println(evidence);
    		}
    		name = name.getNext();
    	}
    	Node node = train.getHead();
    	for (int i = 0; i < train.size(); i++) {
    		String evidence = ((TrainCar)node.getValue()).questionPassenger();
    		int questionMark = evidence.indexOf("?");
    		evidence = evidence.substring(questionMark);
    		evidence = evidence.substring(8);
			System.out.println(evidence);
			for (int j = 0; j < clues.length; j++) {
				if (evidence.contains(clues[j])){
					for (int k = 0; k < names.size(); k++) {
						if (evidence.contains(names.get(k))) {
							matches.set(k, matches.get(k)+1);
							System.out.println(names);
							System.out.println(matches);
						}
					}
				}
			}
			node = node.getNext();
		}
    	int index = 0;
    	for (int i = 0; i < matches.size(); i++) {
    		if (matches.get(i)==3) {
    			index = i;
    			break;
    		}
    	}
    	System.out.println(names.get(index));
        return names.get(index);

    }

}
