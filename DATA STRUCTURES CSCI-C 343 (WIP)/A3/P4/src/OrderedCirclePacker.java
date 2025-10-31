public class OrderedCirclePacker extends AbstractCirclePacker {
    @Override
    public double packWidth(double[] r) {
        // 1) handle n = 0 -> 0
        if (r == null || r.length == 0) return 0.0;

        int n = r.length;
        double[] x = new double[n];

        // 2) place first circle: its center at x[0] = r[0]
        x[0] = r[0];

        // 3) for each i > 0: x[i] = max( r[i], max_{j<i} ( x[j] + sep(r[i], r[j]) ) )
        for (int i = 1; i < n; i++) {
            double xi = r[i]; // at least flush with the left wall
            for (int j = 0; j < i; j++) {
                xi = Math.max(xi, x[j] + sep(r[i], r[j]));
            }
            x[i] = xi;
        }

        // 4) width = max_i (x[i] + r[i])
        double width = 0.0;
        for (int i = 0; i < n; i++) {
            width = Math.max(width, x[i] + r[i]);
        }
        return width;
    }
}
