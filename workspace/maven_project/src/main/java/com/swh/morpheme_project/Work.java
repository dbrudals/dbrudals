package com.swh.morpheme_project;

import java.util.*;

import org.bitbucket.eunjeon.seunjeon.Analyzer;
import org.bitbucket.eunjeon.seunjeon.Eojeol;
import org.bitbucket.eunjeon.seunjeon.LNode;
import org.bitbucket.eunjeon.seunjeon.Morpheme;

public class Work {
	public List<Sentence> work(String a) {
		List<Sentence> senList = new ArrayList<Sentence>();

		int sentenceIndex = 0;
		String sentence = "";

		List<Eojjeol> eojList = new ArrayList<Eojjeol>();
		int eojeolIndex = 0;
		String eojjeol = "";

		int morphIndex = 0;

		for (Eojeol eojeol: Analyzer.parseEojeolJava(a)) {
			List<LNode> mo = eojeol.nodesJava();
			//			System.out.println(eojeol)

			List<Morph> morList = new ArrayList<Morph>();
			for (LNode node: mo) {
				Morpheme y = node.morpheme();
				Morph m = new Morph();
				m.setMorph(y.surface());
				m.setIndex(morphIndex);
				m.setPos(y.feature().head());

				eojjeol += y.surface();
				sentence += y.surface();

				morList.add(m);
				morphIndex+=1;	
			}

			morphIndex=0;

			Eojjeol e = new Eojjeol();
			e.setEojeol(eojjeol);
			e.setIndex(eojeolIndex);
			e.setMorList(morList);
			eojList.add(e);
			eojeolIndex+=1;
			eojjeol="";

			if (mo.get(0).morpheme().feature().head().equals("SF")){

				Sentence s = new Sentence();
				s.setContents(sentence);
				s.setIndex(sentenceIndex);
				s.setEojList(eojList);
				senList.add(s);

				sentence = "";
				s = new Sentence();
				sentenceIndex+=1;
				eojList = new ArrayList<Eojjeol>();
				eojeolIndex=0;
			}

			sentence += " ";
		}
		return senList;
	}
}