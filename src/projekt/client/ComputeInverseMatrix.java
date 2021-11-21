package projekt.client;

import projekt.compute.Compute;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputeInverseMatrix {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);
            double[][] matrix = { { 2104, 5, 1, 45 }, { 1416, 3, 2, 40 },
                { 1534, 3, 2, 30 }, { 852, 2, 1, 36 } };
            InverseMatrix task = new InverseMatrix(matrix);
            double[][] inverseMatrix = comp.executeTask(task);
            System.out.println(inverseMatrix);
        } catch (Exception e) {
            System.err.println("MatrixInverse exception:");
            e.printStackTrace();
        }
    }
}
