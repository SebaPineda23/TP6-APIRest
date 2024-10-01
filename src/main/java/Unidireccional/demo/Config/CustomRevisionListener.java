package Unidireccional.demo.Config;

import Unidireccional.demo.Audit.Revision;
import org.hibernate.envers.RevisionListener;


public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity){final Revision revision = (Revision) revisionEntity;}
}
