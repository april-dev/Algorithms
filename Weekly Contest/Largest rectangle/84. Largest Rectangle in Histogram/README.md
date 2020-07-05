
![1593989902343](https://user-images.githubusercontent.com/66917271/86544008-91c19480-bef1-11ea-9578-fcdc19c9524b.jpg)

The simplest explanation I can give for why the left/right processing is O(N) is that as you do the back-scans you bounce over some nodes and terminate at another and there are N such back-scans.

Each termination happens once per back-scan, so there are O(N) termination steps collectively.

Each node that tells the back-scan to bounce over it will never participate in any future back-scans ever again. So, each node can cause a bounce at most once, thus the bounce steps are also bounded by N.

O(N) terminations + O(N) bounces are thus O(N).

To go into more detail about why an element only ever is processed for a single bounce operation, consider:

i - element we are starting with for a back-scan.
j - element that causes a bounce for the back-scan of i.
k - final element that we find for the back-scan of i.

This situation describes the one bounce that j can cause. For any element after i that we process, we will either terminate before or when we reach i, or we will determine that i is not the end of our search and i will instruct the search to jump to k. Jumping to k bypasses the element at j, so we will never visit j again. If i causes such a bounce, it will also eliminate itself, and the range of that jump must extend over both i and j, so jumping over i continues to prevent any future scans from processing j.

Think of an element that bounces the scan as moving into the shadow of another element. The element at i "hides" the element at j.

Thus, each element can participate in at most one bounce before being eliminated from all future back-scans.
