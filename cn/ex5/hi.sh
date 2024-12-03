sudo apt update
sudo apt install ns2 nam gnuplot
gedit cs.tcl
ns cs.tcl
ls
gedit cs.tr
grep -e ‘^\+|^\-|^r’ cs.tr > filtered_tr.tr
ls
cat filtered_tr.tr | head -n 20
gedit ps.gp
gnuplot ps.gp
ls
eog pf.png