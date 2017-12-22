import Utils._
import ArtBook._

import scala.collection.mutable.ArrayBuffer

object DayTwentyOne {

	def main(args: Array[String]): Unit = {
		def image = Utils.readIn("OriginalImage.txt")
		def artBook = Utils.readIn("DayTwentyOneTestInput.txt")

		val artBookGrids = makeArtBookGrids(artBook)

		solveOne(image, artBookGrids)
	}

	def makeArtBookGrids(artBook: ArrayBuffer[Array[String]]): ArrayBuffer[ArtBook] = {
		artBook.map(bookString => new ArtBook(bookString.mkString("")))
	}

	def solveOne(image: ArrayBuffer[Array[String]], artBookGrids: ArrayBuffer[ArtBook]): Unit = {
		solveOneStep(image, artBookGrids)
	}

	def solveOneStep(image: ArrayBuffer[Array[String]], artBookGrids: ArrayBuffer[ArtBook]): Unit = {
		val imageSize = image.length;
		val (imageDivisor, imageModder) = if (imageSize % 2 == 0) {
			(imageSize / 2, 2)
		} else {
			(imageSize / 3, 3)
		}
		
		val grids = (0 to imageDivisor - 1).flatMap(i => {
			
			// Blocks of n rows
			val rows = image.slice(i * imageModder, (i + 1) * imageModder)
			
			println()	
			println("Block " + i)

				// Block of n grids for the n rows
				val grids = (0 to imageDivisor - 1).map(j => {
					rows.map(_.slice(j * imageModder, (j + 1) * imageModder))		
				})

			//grids.foreach(grid => grid.foreach(row => println(row.mkString(""))))
			grids
		})

		grids.foreach(grid => grid.foreach(row => println(row.mkString(""))))

	}

}
