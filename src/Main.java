import java.util.HashMap;
import java.util.Map;

/**
 * Created by NoOne on 18/10/16.
 */
public class Main {

    static String s = "Frank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,Mary,Bob";
    static Map<String,String> createDict(String[] items){
        Map<String,String> m = new HashMap();
        for ( int i = 0 ; i < items.length - 2 ; i++ ){
            String[] pair = items[i].split("->");
            m.put( pair[1], pair[0] );
        }
        return m;
    }

    static String[] pathToRoot( String employee, Map<String,String> tree){
        StringBuffer buf = new StringBuffer();
        while ( tree.containsKey( employee ) ){
            buf.append( employee ).append( "\t") ;
            employee = tree.get( employee );
        }
        buf.append( employee );
        return buf.toString().split( "\t" );
    }

    static void doIBM( String s ){
        String[] values = s.split(",");
        Map<String,String> tree = createDict( values );
        String emp1 = values[ values.length -2 ] ;
        String emp2 = values[ values.length -1 ] ;
        String[] path1 = pathToRoot( emp1 , tree ) ;
        String[] path2 = pathToRoot( emp2 , tree ) ;
        int len = path1.length < path2.length ? path1.length : path2.length ;
        String resolver = "" ;

        for ( int i = 0; i <  len-1 ; i++ ){
            if  ( !path1[ path1.length - 1 - i ].equals( path2[ path2.length -1 - i] ) ) {
                break;
            }
            resolver = path1[ path1.length - 1 - i ];
        }
        System.out.println(resolver);
    }

    public static void main(String[] args){
        doIBM(s);
    }
}