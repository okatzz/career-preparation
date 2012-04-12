package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * A spreadsheet consists of a two-dimensional array of cells, labeled
 * A1, B1, ...., A2, B2, ....
 * Each cell contains either a number (its value) or an expression.
 * 
 * <p> For simplicity, expressions are given as RPN (reverse-polish notation).
 * They contain space-separated terms that are either numbers (in our case
 * non-negative values), cell references, and the operators '+', '-', '*', '/'.
 * 
 * <p>Examples:
 *
 *  +----------------------+------------------+--------------+
 *  | RPN                  | infix notation   | evaluates to |
 *  +----------------------+------------------+--------------+
 *  | "10 4 /"             | "10/4"           |          2.5 |  
 *  +----------------------+------------------+--------------+
 *  | "10 1 1 + / 1 +"     | "10/(1+1) + 1    |          6.0 | 
 *  +----------------------+------------------+--------------+
 *  | "10 2 3 + / 4 5 + *" | "10/(2+3)*(4+5)" |         18.0 |
 *  +----------------------+------------------+--------------+
 *
 * <p> Your task is to implement a functional SpreadSheet. The main
 * functionality is:
 * <li> 1. constructor: construct the spreadsheet from the provided expressions.
 * <li> 2. dump(): solve the spreadsheet and return the result. If
 * a cycle of references exists, detect it and throw a
 * CircularReferenceException.
 * 
 * <p>
 * Comments: You can assume that there are no more than 26 columns (A-Z) in the spreadsheet.
*/
public class SpreadSheet {
	
	int nRows;
	int nCols;
	
	private Cell[][] cellMatrix;
	
	
	
	class Cell{
		private String expression;
		private Double value = null;
		
		private int inDegree=0;
		private ArrayList<Cell> dependents=null;
		
		Cell(String exp){
			this.expression=exp;
			this.value=null;
			dependents=new ArrayList<Cell>();
		}

		String getExpression() {
			return expression;
		}

		void setExpression(String expression) {
			this.expression = expression;
		}

		Double getValue() {
			return value;
		}


		ArrayList<Cell> getDependents() {
			return dependents;
		}
		
		void addDependent(Cell cell) {
			dependents.add(cell);
		}
		
		void setInDegree(int d){
			inDegree=d;
		}
		
		boolean decrementInDegreeAndCheckZero(){
			--inDegree;
			return inDegree==0;
		}
		
		ArrayList<String> getReferences(){
			ArrayList<String> refs=new ArrayList<String>();
			String[] strs=expression.split(" ");
			for(String s: strs){
				if(isReference(s)){
					refs.add(s);
				}
			}
			setInDegree(refs.size());
			return refs;
		}
		

		void computeValue() {
			Stack<Double> stack = new Stack<Double>();
			String[] terms = expression.split(" ");
			for(String term: terms){
				if(isNumber(term)){
					stack.push(Double.parseDouble(term));
				}else if(isReference(term)){
					stack.push(getCellFromRef(term).getValue());
				}else{
					Double op1=(Double)stack.pop();
					Double op2=(Double)stack.pop();
					Double result=calculater(op1, op2, term);
					stack.push(result);
				}
			}
			value=(Double)stack.pop();
		}
		
		private Double calculater(Double op1, Double op2, String term) {
			
			Double result=null;
			switch(term.charAt(0)){
			case '+':
				result=new Double(op2+op1);
				break;
			case '-':
				result=new Double(op2-op1);
				break;
			case '*':
				result=new Double(op2*op1);
				break;
			case '/':
				result=new Double(op2/op1);
			}
			return result;
		}

		private boolean isNumber(String s){
			return s!=null && s.length()>0 && (Character.isDigit(s.charAt(0)) || s.charAt(0)=='.');
		}
		
		private boolean isReference(String s){
			return s!=null && s.length()>=2 && Character.isUpperCase(s.charAt(0));
		}


		
		
	}
	
	class TopGraph{
		private int count = 0;
		private int sheetSize;
		private LinkedList<Cell> queue = null;
		
		TopGraph(int size){
			count=0;
			sheetSize=size;
			queue = new LinkedList<Cell>();
		}
		
		

		void enqueue(Cell cell) {
			queue.add(cell);
		}
		
		Cell dequeue(){
			return (Cell)queue.removeFirst();
		}



		public void solve() throws CircularReferenceException {
			while(!queue.isEmpty()){
				Cell cell = dequeue();
				count++;
				cell.computeValue();
				for(Cell dep: cell.getDependents()){
					if(dep.decrementInDegreeAndCheckZero()){
						enqueue(dep);
					}
				}
			}
			
			if(count<sheetSize){
				throw new CircularReferenceException("Circular reference exists!");
			}
			
		}
	}
	
	private TopGraph topGraph;
	
	
	
	

    /**
     * Construct a nRows x nCols SpreadSheet, with cells containing
     * the expressions passed in the exprArray.
     * 
     * <p> The expressions passed in the exprArray String array are in row
     * by row order, i.e.:

     * +----+----+----+
     * | A1 | B1 | C1 |
     * +----+----+----+
     * | A2 | B2 | C2 |
     * +----+----+----+
     *
     * etc.
     * @param nRows
     * @param nCols
     * @param exprArray
     */
    public SpreadSheet(int nRows, int nCols, String... exprArray) {
        // TODO: put your code here
    	this.nRows=nRows;
    	this.nCols=nCols;
    	
    	this.cellMatrix = new Cell[nRows][nCols];
    	for(int i=0; i<nRows; i++){
    		cellMatrix[i]=new Cell[nCols];
    		for(int j=0; j<nCols; j++){
    			cellMatrix[i][j]=new Cell(exprArray[i*nCols+j]);
    		}
    	}
    }
    
    private TopGraph generateTopGraph(){
    	TopGraph topGraph = new TopGraph(nRows*nCols);
    	for(int i=0; i<nRows; i++){
    		for(int j=0; j<nCols; j++){
    			Cell cell = cellMatrix[i][j];
    			ArrayList<String> refs = cell.getReferences();
    			if(refs.size()==0){
    				topGraph.enqueue(cell);
    			}else{
    				for(String ref: refs){
    					Cell cd = getCellFromRef(ref);
    					cd.addDependent(cell);
    				}
    			}
    		}
    	}
    	return topGraph;
    }
    
    private void topSolve() throws  CircularReferenceException{
		
		this.topGraph.solve();
	}
    
    private Cell getCellFromRef(String ref) {
		int col = ref.charAt(0)-'A';
		int row = Integer.parseInt(ref.substring(1))-1;
		return cellMatrix[row][col];
	}
    
	private Double[] output() {
		Double[] out = new Double[nRows*nCols];
		for(int i=0; i<nRows; i++){
    		for(int j=0; j<nCols; j++){
    			out[i*nCols+j]=cellMatrix[i][j].getValue();
    		}
    	}
		return out;
	}

	/**
     * @return the values from a "solved" SpreadSheet
     */
    public Double[] dump() throws CircularReferenceException {
        
    	this.topGraph = generateTopGraph();
    	topSolve();
        return output();
    }

}

	 class CircularReferenceException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public CircularReferenceException(String msg) {
            super(msg);
        }
    }

    
    

