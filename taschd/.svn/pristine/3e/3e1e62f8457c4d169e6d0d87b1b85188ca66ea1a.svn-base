package edu.udel.cis.taschd.gen;

import java.util.Arrays;

/**
 * <p>
 * Solve an n-by-n assignment problem. Given a n-by-n cost matrix, find the
 * lowest cost of biparties assginment. e.g n this simple example there are
 * three workers: Armond, Francine, and Herbert. One of them has to clean the
 * bathroom, another sweep the floors and the third washes the windows, but they
 * each demand different pay for the various tasks. The problem is to find the
 * lowest-cost way to assign the jobs. The problem can be represented in a
 * matrix of the costs of the workers doing the jobs. For example:
 * 
 * Clean bathroom Sweep floors Wash windows Armond $2 $3 $3 Francine $3 $2 $3
 * erbert $3 $3 $2 The Hungarian method, when applied to the above table, would
 * give the minimum cost: this is $6, achieved by having Armond clean the
 * bathroom, Francine sweep the floors, and Herbert wash the windows.
 * 
 * </p>
 * 
 * 
 * @author https://www.sanfoundry.com/java-program-implement-hungarian-algorithm-bipartite-matching/
 * 
 * @author Yi Liu
 */
public class Hungarian

{

	/**
	 * this is a m by m matrix storing the cost
	 */
	private final double[][] costMatrix;

	/**
	 * rows is number of rows in the costMastrix
	 * cols is number of cols in the costMastrix
	 * dim is the dimension of the costMatrix
	 */
	private final int rows, cols, dim;
	
	/**
	 *each work has a label, store in array.
	 *each Job has a label, store in array
	 */
	private final double[] labelByWorker, labelByJob;
	
	/**
	 * for each row find the minimum cost worker
	 */
	private final int[] minSlackWorkerByJob;

	/**
	 * for each column find the minimum cost worker by the job
	 */
	private final double[] minSlackValueByJob;
	
	/**
	 * An array  to save the match information
	 */
	private final int[] matchJobByWorker, matchWorkerByJob;

	/**
	 * Find the assign by job
	 */
	private final int[] parentWorkerByCommittedJob;
	
	/**
	 * if the worker is assigned or committed.
	 */
	private final boolean[] committedWorkers;

	/**
	 * Constructs a new {@link Hungarian} with given {@link double[][] costMatrix}
	 *
	 * @param costMatrix a N by N matrix
	 * 
	 */
	public Hungarian(double[][] costMatrix)

	{

		this.dim = Math.max(costMatrix.length, costMatrix[0].length);

		this.rows = costMatrix.length;

		this.cols = costMatrix[0].length;

		this.costMatrix = new double[this.dim][this.dim];

		for (int w = 0; w < this.dim; w++)

		{

			if (w < costMatrix.length)

			{

				if (costMatrix[w].length != this.cols)

				{

					throw new IllegalArgumentException("Irregular cost matrix");

				}

				this.costMatrix[w] = Arrays.copyOf(costMatrix[w], this.dim);

			}

			else

			{

				this.costMatrix[w] = new double[this.dim];

			}

		}

		labelByWorker = new double[this.dim];

		labelByJob = new double[this.dim];

		minSlackWorkerByJob = new int[this.dim];

		minSlackValueByJob = new double[this.dim];

		committedWorkers = new boolean[this.dim];

		parentWorkerByCommittedJob = new int[this.dim];

		matchJobByWorker = new int[this.dim];

		Arrays.fill(matchJobByWorker, -1);

		matchWorkerByJob = new int[this.dim];

		Arrays.fill(matchWorkerByJob, -1);

	}

	/**
	 * 
	 * 
	 *
	 * 
	 * Heuristics to improve performance: Reduce rows and columns by their
	 * 
	 * smallest element, compute an initial non-zero dual feasible solution
	 * 
	 * and
	 * 
	 * create a greedy matching from workers to jobs of the cost matrix.
	 * 
	 * Create a greedy matching from workers to jobs of the cost matrix. This method
	 * wilL
	 * 
	 * @return an array of assignment.
	 */
	public int[] execute()

	{

		reduce();

		computeInitialFeasibleSolution();

		greedyMatch();

		int w = fetchUnmatchedWorker();

		while (w < dim)

		{

			initializePhase(w);

			executePhase();

			w = fetchUnmatchedWorker();

		}

		int[] result = Arrays.copyOf(matchJobByWorker, rows);

		for (w = 0; w < result.length; w++)

		{

			if (result[w] >= cols)

			{

				result[w] = -1;

			}

		}

		return result;

	}

	/**
	 * 
	 * This method compute initial feasible solution.
	 */
	protected void computeInitialFeasibleSolution()

	{

		for (int j = 0; j < dim; j++)

		{

			labelByJob[j] = Double.POSITIVE_INFINITY;

		}

		for (int w = 0; w < dim; w++)

		{

			for (int j = 0; j < dim; j++)

			{

				if (costMatrix[w][j] < labelByJob[j])

				{

					labelByJob[j] = costMatrix[w][j];

				}

			}

		}

	}

	/**
	 * 
	 * Execute phase
	 */
	protected void executePhase()

	{

		while (true)

		{

			int minSlackWorker = -1, minSlackJob = -1;

			double minSlackValue = Double.POSITIVE_INFINITY;

			for (int j = 0; j < dim; j++)

			{

				if (parentWorkerByCommittedJob[j] == -1)

				{

					if (minSlackValueByJob[j] < minSlackValue)

					{

						minSlackValue = minSlackValueByJob[j];

						minSlackWorker = minSlackWorkerByJob[j];

						minSlackJob = j;

					}

				}

			}

			if (minSlackValue > 0)

			{

				updateLabeling(minSlackValue);

			}

			parentWorkerByCommittedJob[minSlackJob] = minSlackWorker;

			if (matchWorkerByJob[minSlackJob] == -1)

			{

				/*
				 * 
				 * An augmenting path has been found.
				 * 
				 */

				int committedJob = minSlackJob;

				int parentWorker = parentWorkerByCommittedJob[committedJob];

				while (true)

				{

					int temp = matchJobByWorker[parentWorker];

					match(parentWorker, committedJob);

					committedJob = temp;

					if (committedJob == -1)

					{

						break;

					}

					parentWorker = parentWorkerByCommittedJob[committedJob];

				}

				return;

			}

			else

			{

				/*
				 * 
				 * Update slack values since we increased the size of the
				 * 
				 * committed
				 * 
				 * workers set.
				 * 
				 */

				int worker = matchWorkerByJob[minSlackJob];

				committedWorkers[worker] = true;

				for (int j = 0; j < dim; j++)

				{

					if (parentWorkerByCommittedJob[j] == -1)

					{

						double slack = costMatrix[worker][j]

								- labelByWorker[worker] - labelByJob[j];

						if (minSlackValueByJob[j] > slack)

						{

							minSlackValueByJob[j] = slack;

							minSlackWorkerByJob[j] = worker;

						}

					}

				}

			}

		}

	}

	/**
	 * 
	 * This method will find unmatched worker
	 * 
	 * @return w, the index of the worker  
	 *
	 */
	protected int fetchUnmatchedWorker()

	{

		int w;

		for (w = 0; w < dim; w++)

		{

			if (matchJobByWorker[w] == -1)

			{

				break;

			}

		}

		return w;

	}

	/**
	 * Find the match with lowest cost.
	 * 
	 */
	protected void greedyMatch()

	{

		for (int w = 0; w < dim; w++)

		{

			for (int j = 0; j < dim; j++)

			{

				if (matchJobByWorker[w] == -1

						&& matchWorkerByJob[j] == -1

						&& costMatrix[w][j] - labelByWorker[w] - labelByJob[j] == 0)

				{

					match(w, j);

				}

			}

		}

	}

	/**
	 * Initialize Phase, lowest element subtracted from each element in that row
	 */
	protected void initializePhase(int w)

	{

		Arrays.fill(committedWorkers, false);

		Arrays.fill(parentWorkerByCommittedJob, -1);

		committedWorkers[w] = true;

		for (int j = 0; j < dim; j++)

		{

			minSlackValueByJob[j] = costMatrix[w][j] - labelByWorker[w]

					- labelByJob[j];

			minSlackWorkerByJob[j] = w;

		}

	}

	/**
	 * take row and col number
	 * and save the result
	 * 
	 * @param w,j
	 * 
	 */
	protected void match(int w, int j)

	{

		matchJobByWorker[w] = j;

		matchWorkerByJob[j] = w;

	}

	
	/**
	 * 
	 * Reduce the minum number of the 
	 * 
	 * Cost table 
	 * 
	 */
	protected void reduce()

	{

		for (int w = 0; w < dim; w++)

		{

			double min = Double.POSITIVE_INFINITY;

			for (int j = 0; j < dim; j++)

			{

				if (costMatrix[w][j] < min)

				{

					min = costMatrix[w][j];

				}

			}

			for (int j = 0; j < dim; j++)

			{

				costMatrix[w][j] -= min;

			}

		}

		double[] min = new double[dim];

		for (int j = 0; j < dim; j++)

		{

			min[j] = Double.POSITIVE_INFINITY;

		}

		for (int w = 0; w < dim; w++)

		{

			for (int j = 0; j < dim; j++)

			{

				if (costMatrix[w][j] < min[j])

				{

					min[j] = costMatrix[w][j];

				}

			}

		}

		for (int w = 0; w < dim; w++)

		{

			for (int j = 0; j < dim; j++)

			{

				costMatrix[w][j] -= min[j];

			}

		}

	}

	
	/**
	 * 
	 * Update the label  
	 * 
	 * @param slack
	 * 
	 */
	protected void updateLabeling(double slack)

	{

		for (int w = 0; w < dim; w++)

		{

			if (committedWorkers[w])

			{

				labelByWorker[w] += slack;

			}

		}

		for (int j = 0; j < dim; j++)

		{

			if (parentWorkerByCommittedJob[j] != -1)

			{

				labelByJob[j] -= slack;

			}

			else

			{

				minSlackValueByJob[j] -= slack;

			}

		}

	}

}