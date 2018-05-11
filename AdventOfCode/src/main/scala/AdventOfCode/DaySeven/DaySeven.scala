package AdventOfCode.DaySeven

import AdventOfCode.Utils.ReadFileUtils

object DaySeven {

  def main(args: Array[String]): Unit = {
    val input = ReadFileUtils.readFileAsStringList("/AdventOfCode/DaySeven/DaySeven.txt")
    println(partOne(input).name)
    println(partTwo(input))
  }

  def partOne(input: List[String]): Node = {
    val baseNodeMap = generateBaseNodeMap(input)
    val completeNodeMap = generateCompleteNodeMap(input, baseNodeMap)
    findBottom(completeNodeMap)
  }

  def partTwo(input: List[String]): Int = {
    val baseNodeMap = generateBaseNodeMap(input)
    val completeNodeMap = generateCompleteNodeMap(input, baseNodeMap)
    val bottom = findBottom(completeNodeMap)
    val treeAmount = bottom.subNodes.map(sumTree)

    1
  }

  def sumTree(node: Node): Int = {
    node.value + node.subNodes.map(sumTree).sum
  }

  def generateBaseNodeMap(input: List[String]): NodeMap = {
    NodeMap((for {
      inputLine <- input
      node = readLineToSingleNode(inputLine)
    } yield (node.name, node)).toMap)
  }

  def readLineToSingleNode(line: String): Node = {
    val Array(name, weight) = line.split("\\s+").take(2)
    val cleanWeight = weight.filter(c => c.isDigit).toInt
    Node(name, cleanWeight, Vector())
  }

  def generateCompleteNodeMap(input: List[String], nodeMap: NodeMap): NodeMap = {
    NodeMap(input.map(line => {
        val splitLine = line.split("\\s+")
        val nodeKey = splitLine.take(1)(0)
        val subNodeKeys = splitLine.drop(3).map(str => str.replaceAll(",", ""))
        val node = nodeMap.get(nodeKey).get
        val subNodes = subNodeKeys.map(k => nodeMap.get(k).get).toVector
       (node.name, Node(node.name, node.value, subNodes))
    }).toMap)
  }

  def findBottom(nodeMap: NodeMap): Node = {
    val allNodes = nodeMap.nodes.valuesIterator.toList
    val allNodeNames = allNodes.map(n => n.name)
    val supportedNodeNames = allNodes.flatMap(n => n.subNodes).map(n => n.name)
    val bottomNodeName = allNodeNames.filterNot(supportedNodeNames.toSet)(0)

    nodeMap.get(bottomNodeName).get
  }

}
