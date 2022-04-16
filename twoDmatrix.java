import java.util.Scanner;
class matrix{
	int row;
	int col;
	double[][] mat=new double[row][col];
	matrix(int r,int c) {
	row=r;
	col=c;
	mat=new double[r][c];
	}
	double[][] getData(){
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++)mat[i][j]=sc.nextDouble();		
		}		
		return mat;
		
	}
	void printmatrix() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}
	matrix transpose() {
	 matrix trans=new matrix(col,row);
	 for(int i=0;i<col;i++) {
			for(int j=0;j<row;j++) trans.mat[i][j]=mat[j][i];			
		}
	 return trans;
	}
	matrix delrow(int rowRemove) {
		matrix m=new matrix(row-1,col);
		 for(int j = 0; j < col; j++)
			    
		    {
		    	for(int i = 0,currRow=0;i<row; i++)
		    	
		        {
		            if(i != rowRemove)
		            {
		                m.mat[currRow++][j] = mat[i][j];
		            }
		        }
		    }
		 return m;
	}
	matrix delcol(int colRemove) {
		matrix n=new matrix(row,col-1);
		for(int i = 0; i < row; i++)
	    {
	        for(int j = 0,currColumn=0; j < col; j++)
	        {
	            if(j != colRemove)
	            {
	                n.mat[i][currColumn++] = mat[i][j];
	            }
	        }
	    }
		return n;
	}
	matrix minor(int i,int j) {
		matrix k=this.delrow(i);
		matrix p=k.delcol(j);
		return p;
	}
	double determinant() {
		if(row!=col) {System.out.println("Matrix not square");
		return -9999;
		}
		else if(row==1&&col==1) return(mat[0][0]);
		else {
			double det=0;
			for(int j=0;j<col;j++) det+=mat[0][j]*Math.pow(-1.0, j)*minor(0,j).determinant();
			return det;
		}
	}
	matrix multiply(matrix n) {
		if(this.col!=n.row) {
			System.out.println("Matrix dimensions not compatible");
			return n;
		}
		else {
			matrix p= new matrix(this.row,n.col);
			for(int i=0;i<this.row;i++) {
				for(int k=0;k<this.col;k++) {
					for(int j=0;j<n.col;j++) p.mat[i][j]+=mat[i][k]*n.mat[k][j];
				}
			}
			return p;
		}
	}
	matrix adjoint() {
		matrix adj=new matrix(row,col);
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++)adj.mat[i][j]=minor(i,j).determinant()*Math.pow(-1.0, i+j+2);
			}
			return adj.transpose();
		}
	matrix inverse() {
		matrix inv=new matrix(row,col);
		matrix A=this.adjoint();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++)inv.mat[i][j]=A.mat[i][j]/this.determinant();
		}
		return inv;
	}
	
	}
			
	
	
		

public class twoDmatrix {

	public static void main(String[] args) {
		matrix m=new matrix(3,3);
		m.getData();
		matrix r=m.inverse();
		(r.multiply(m)).printmatrix();
		matrix x=new matrix(3,1);
		x.getData();
		matrix h=m.inverse().multiply(x);		
		m.printmatrix();
		x.printmatrix();
		h.printmatrix();
	/*	System.out.println();
		matrix n=m.transpose();
		n.printmatrix();
		System.out.println();
		matrix dr=n.delrow(1);
		dr.printmatrix();
		System.out.println();
		matrix cr=n.delcol(0);
		cr.printmatrix();
		System.out.println();
		matrix q=m.minor(1, 1);
		q.printmatrix();
		System.out.println();
		System.out.println(m.determinant());
		System.out.println();
		matrix k=m.multiply(n);
		k.printmatrix();
		System.out.println();
		q=m.inverse();
		q.printmatrix();*/
		

	}

}
