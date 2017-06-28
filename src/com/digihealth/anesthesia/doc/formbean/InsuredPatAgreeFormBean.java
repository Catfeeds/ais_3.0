package com.digihealth.anesthesia.doc.formbean;

import java.util.List;

import com.digihealth.anesthesia.doc.po.DocInsuredItem;
import com.digihealth.anesthesia.doc.po.DocInsuredPatAgree;

public class InsuredPatAgreeFormBean
{
    private DocInsuredPatAgree docInsuredPatAgree;
    
    private List<DocInsuredItem> docInsuredItemList;

    public DocInsuredPatAgree getDocInsuredPatAgree()
    {
        return docInsuredPatAgree;
    }

    public void setDocInsuredPatAgree(DocInsuredPatAgree docInsuredPatAgree)
    {
        this.docInsuredPatAgree = docInsuredPatAgree;
    }

    public List<DocInsuredItem> getDocInsuredItemList()
    {
        return docInsuredItemList;
    }

    public void setDocInsuredItemList(List<DocInsuredItem> docInsuredItemList)
    {
        this.docInsuredItemList = docInsuredItemList;
    }
}
