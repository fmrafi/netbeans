package schoollibrary;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import schoollibrary.Authors;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-13T01:32:36")
@StaticMetamodel(Books.class)
public class Books_ { 

    public static volatile SingularAttribute<Books, Authors> author;
    public static volatile SingularAttribute<Books, String> edition;
    public static volatile SingularAttribute<Books, Integer> id;
    public static volatile SingularAttribute<Books, String> title;

}