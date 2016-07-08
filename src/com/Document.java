package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo on 22/06/2016.
 */
public class Document implements IDocumentPart {
    private List<IDocumentPart> documentComposition;

    public Document() {
        documentComposition = new ArrayList<>();
    }

    public void addChapter(final Chapter chapter){
        documentComposition.add(chapter);
    }

    public List<IDocumentPart> getDocumentComposition() {
        return documentComposition;
    }

    @Override
    public String print(IDocumentPartVisitor iDocumentPartVisitor) {
        return iDocumentPartVisitor.print(this);

    }
}
