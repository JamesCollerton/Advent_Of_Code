import Utils._
import Instruction._

import scala.collection.mutable.HashMap
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer

object DayEighteen {

	def main(args: Array[String]): Unit = {
		val input = Utils.readIn("DayEighteenInput.txt")
		solveOne(input)	
	}

	def solveOne(instructions: ArrayBuffer[Instruction]): Unit = {
//		println("Last sound " + solveOneStep(new HashMap[String, Double], 0, 0, instructions))
		val runnable = new ProgramThread(0, instructions, new Queue[Int]) 
		val thread = new Thread(runnable)
		thread.start()
	}

	def solveTwo(instructions: ArrayBuffer[Instruction]): Unit = {
		
		// If program zero is not waiting then run

		// If program one is not waiting then run

	}

//	@annotation.tailrec
//	def solveOneStep(registers: HashMap[String, Double], currPosition: Int, lastSound: Double, instructions: ArrayBuffer[Instruction]): Double = {
//		// If we're off the edge
//		if(currPosition < 0 || currPosition >= instructions.length) return lastSound
//
//		// Get current instruction
//		val currInstruction = instructions(currPosition)
//
//		// If register never seen before then add.
//		if(!registers.contains(currInstruction.register)) registers(currInstruction.register) = 0
//
//		// Get amount and current value
//		val amountValue = getAmountValue(registers, currInstruction)
//		val currentValue = registers(currInstruction.register)
//
//		// Setting current register
//		registers(currInstruction.register) = currInstruction.instruction match {
//			case "set" => amountValue
//			case "add" => currentValue + amountValue
//			case "mul" => currentValue * amountValue
//			case "mod" => currentValue % amountValue
//			case "rcv" => if(currentValue != 0) lastSound else registers(currInstruction.register)
//			case _ => registers(currInstruction.register)
//		}
//
//		// Setting last sound
//		val newLastSound = currInstruction.instruction match {
//			case "snd" => if(currentValue >0) currentValue else lastSound
//			case _ => lastSound
//		}
//
//		// Setting next position
//		val nextPosition = currInstruction.instruction match {
//			case "jgz" => if(currentValue > 0) currPosition + amountValue.toInt else currPosition + 1
//			case _ => currPosition + 1
//		}
//
//		println()
//		println(currInstruction.printline)
//		println("Register " + currInstruction.instruction)
//		println("New register value " + registers(currInstruction.register))
//		println("New last sound " + newLastSound)
//		println("Next position " + nextPosition)
//		println("Current registers " + registers.map(x => "(" + x._1 +"," + x._2 +")").mkString(", ")) 
//		
//		// Have we ended?
//		if(currInstruction.instruction == "rcv" && currentValue != 0 && lastSound != 0) {
//			println()
//			return lastSound
//		}
//
//		solveOneStep(registers, nextPosition, newLastSound, instructions)
//	}	
//
//	def getAmountValue(registers: HashMap[String, Double], currInstruction: Instruction): Double = {
//		val amountValue = try {
//			currInstruction.amount.toDouble
//		} catch {
//			case _: Throwable => {
//				val register = currInstruction.amount
//				if(register != null) {
//					if(!registers.contains(register)) registers(register) = 0
//					registers(register)
//				} else {
//					0
//				}
//			}
//		}
//		amountValue
//	}

}