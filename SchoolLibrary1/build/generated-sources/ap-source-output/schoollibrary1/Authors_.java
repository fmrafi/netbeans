package schoollibrary1;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import schoollibrary1.Books;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-16T00:17:16")
@StaticMetamodel(Authors.class)
public class Authors_ { 

    public static volatile SingularAttribute<Authors, String> firstname;
    public static volatile CollectionAttribute<Authors, Books> booksCollection;
    public static volatile SingularAttribute<Authors, String> surname;
    public static volatile SingularAttribute<Authors, Integer> id;
    public static volatile SingularAttribute<Authors, String> email;

}