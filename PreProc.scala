import scala.io.Source
import java.io.PrintWriter
import java.io.File
import scala.collection.mutable.StringBuilder
import scala.util.matching.Regex


object PreProc{
    def main(args:Array[String]){
        val inputfile = "BigData/enwiki-latest-pages-articles-multistream.xml"
        val outputfile = new PrintWriter(new File("outputfile"))
        var a_output_line = new StringBuilder
        val regex = "<page>".r
        val regex_2 = "</page>".r
        var found = false
        var count =0


    for (inputline <- Source.fromFile(inputfile).getLines){
        if(found)
        {

            outputfile.write(inputline)
        }
        for(m <-regex.findAllIn(inputline))
        {

           outputfile.write(inputline)
            found = true
            count += 1
        }
        for(m<-regex_2.findAllIn(inputline))
        {

            found = false
            outputfile.println();
        }

}
outputfile.close
println(count)

}
}

//for loop read each line
//if start with <page> write out to output,i
//val regex = "(?s)<page>(.*?)</page>".r
//val lines = Source.fromFile("wikidump.example").mkString
//println(lines)
//val result = regex.findAllIn(lines)
//for(m <-regex.findAllIn(lines))println(m)
//result.collect.foreach(println)
//println(result)
//DigData/enwiki-latest-pages-articles-multistream.xml
