package com;

import java.util.List;

/**
 * Created by Ricardo on 22/06/2016.
 */
public class DocumentPartVisitor implements IDocumentPartVisitor {

    @Override
    public String print(Document e) {
        String finalString = "";
        List<IDocumentPart> documentComposition = e.getDocumentComposition();
        for(IDocumentPart documentPart: documentComposition){
            finalString += documentPart.print(this);
        }
        return finalString;
    }

    @Override
    public String print(Chapter e) {
        String s = "";
        final List<IDocumentPart> characterList = e.getChapterComposition();
        for(IDocumentPart d : characterList){
            s += d.print(this);
        }

        return s;
    }

    @Override
    public String print(Paragraph e) {
        String s = "";
        final List<Character> characterList = e.getCharacterList();
        final List<Integer> rle = e.getRleCompression();
        int characterCounter = 0;
        boolean upperCase = true;

        for(int i = 0 ; i<rle.size(); i++) {
            for (int j = 0; j<rle.get(i); j++) {
                s += this.print(characterList.get(characterCounter++), upperCase);
            }
            upperCase = !upperCase;
        }
        return s;
    }

    @Override
    public String print(Character e, boolean upperCase) {
        return (upperCase ? java.lang.Character.toUpperCase(e.getCharacter()) : e.getCharacter()) + "";
    }
}
