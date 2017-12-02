import scala.io.Source
import scala.collection.mutable.ArrayBuffer

object DayTwo {

	def readIn(): ArrayBuffer[Array[Int]] = {

		def readRows(resource: Source): ArrayBuffer[Array[Int]] = {
			val rows = ArrayBuffer[Array[Int]]()

			for (line <- resource.getLines) {
				rows += line.split("\t").map(_.trim.toInt)
			}

			//printRows(rows)

			rows
		}

		def printRows(rows : ArrayBuffer[Array[Int]]): Unit = {
			for(fieldRow <- rows){
				println(fieldRow.mkString(" "));
			}
		}

		def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B = {
			try {
				f(resource)
			} finally {
				resource.close;
			}
		}

		using(Source.fromFile("DayTwoInput.txt"))(readRows);		

	}
	
	def calculateChecksum(rows: ArrayBuffer[Array[Int]]): Int = {
		if(rows.size == 0) return 0
		val currRow = rows(0)
		var divided = currRow(0)
		var divisor = currRow(0)
		for(field <- currRow){
			currRow.map(a => a % field == 0);
		}
		println("Row " + currRow.mkString(" "))
		println("Divided " + divided)
		println("Divisor " + divisor)
		println()
		calculateChecksum(rows.slice(1, rows.length)) + 0
	}

	def main(args: Array[String]): Unit = {
		val rows = readIn();
		println("Checksum " + calculateChecksum(rows));
	}	

}
