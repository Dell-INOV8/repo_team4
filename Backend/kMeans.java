/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dellconnect;

import java.util.ArrayList;
import javafx.geometry.Point3D;

/**
 * Machine Learning Algorithm to cluster preferences. This will be used to
 * choose friend suggestions based off of preferences and social mode (After
 * Hours vs. Professional mode)
 *
 * @author Chance
 */
public class kMeans {

    static final Integer k = 3; // Number of clusters you want
    boolean professional;
    ArrayList<Profile> users;
    ArrayList<Integer> clusterSet;  // Parallel ArrayList to users to identify which cluster they belong to
    ArrayList<Point3D> clusterCenters; // Holds the centers of each of the k clusters

    public kMeans(ArrayList<Profile> users, boolean professional) {
        this.users = users;
        this.professional = professional;
        init(clusterCenters, clusterSet, users);
        executeKMeans();
    }

    public ArrayList<Integer> getUpdatedClusters(ArrayList<Profile> users) {
        this.users = users;
        executeKMeans();
        return clusterSet;
    }

    private double distance(Profile p1, Point3D p2) {
        if (professional) {
            return Math.pow(Math.pow(p2.getX() - p1.getTechnologyPreference(), 2) + Math.pow(p2.getY() - p1.getBusinessPreference(), 2) + Math.pow(p2.getZ() - p1.getManagementPreference(), 2), .5);
        } else {
            return Math.pow(Math.pow(p2.getX() - p1.getCookingPreference(), 2) + Math.pow(p2.getY() - p1.getGamingPreference(), 2) + Math.pow(p2.getZ() - p1.getHikingPreference(), 2), .5);
        }
    }

    /**
     * Initializes the clusters to spoof center points
     * @param c
     * @param A
     * @param S 
     */
    private void init(ArrayList<Point3D> c, ArrayList<Integer> A, ArrayList<Profile> S) {
        ArrayList<Point3D> tempC = new ArrayList<>();

        // Initialize initial cluster points 
        tempC.add(new Point3D(1.666, 1.666, 1.666));
        tempC.add(new Point3D(4.666, 4.666, 4.666));
        tempC.add(new Point3D(7.666, 7.666, 7.666));

        c = tempC;

        for (int i = 0; i < S.size(); ++i) {	// Iterate through each point
            double minDistance = Double.MAX_VALUE;
            int bestCluster = -1;
            for (int j = 0; j < k; ++j) {	// Iterate through each cluster
                double similarity = distance(S.get(i), c.get(j));
                if (similarity < minDistance) {	// If distance is better than minDistance, it's the best point to add to the cluster
                    bestCluster = j;
                    minDistance = similarity;
                }
            }
            A.set(i, bestCluster);
        }
    }

    /**
     * Recalculates the clusters
     * @param c
     * @param A
     * @param S
     * @return 
     */
    private ArrayList<Point3D> recalcClusterLoc(ArrayList<Point3D> c, ArrayList<Integer> A, ArrayList<Profile> S) {
        for (int i = 0; i < k; ++i) {
            double totalX = 0;
            double totalY = 0;
            double totalZ = 0;
            double count = 0;
            for (int j = 0; j < S.size(); ++j) {
                if (A.get(j) == i) {
                    if (professional) {
                        totalX += S.get(j).getTechnologyPreference();
                        totalY += S.get(j).getBusinessPreference();
                        totalZ += S.get(j).getManagementPreference();
                    } else {
                        totalX += S.get(j).getCookingPreference();
                        totalY += S.get(j).getGamingPreference();
                        totalZ += S.get(j).getHikingPreference();
                    }
                }
                ++count;
            }
            // Recalculate center
            c.set(i, new Point3D(totalX / count, totalY / count, totalZ / count));
        }
        return c;
    }

    /**
     * Calculates the best clusters for each profile based on their preferences
     */
    private void executeKMeans() {

        boolean change = true;
        recalcClusterLoc(clusterCenters, clusterSet, users);

        while (change) {
            change = false;
            for (int i = 0; i < users.size(); ++i) {
                double minDistance = distance(users.get(i), clusterCenters.get(clusterSet.get(i)));
                int bestCluster = clusterSet.get(i);
                for (int j = 0; j < k; ++j) {
                    double similarity = distance(users.get(i), clusterCenters.get(j));
                    if (similarity < minDistance) {
                        bestCluster = j;
                        minDistance = similarity;
                    }
                }
                if (clusterSet.get(i) != bestCluster) {
                    clusterSet.set(i, bestCluster);
                    change = true;
                    recalcClusterLoc(clusterCenters, clusterSet, users);
                }
            }
        }
    }
}
