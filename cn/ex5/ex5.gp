set terminal pngcairo
set output 'packet_flow.png'
set title 'Packet Flow Over Time'
set xlabel 'Time (s)'
set ylabel 'Packet Flow'
set xrange [0:*]
set yrange [0:*]
plot "valid_data.tr" using ($2):($4) with lines title 'Packet Flow (Sent)' linecolor rgb 'blue', \
"valid_data.tr" using ($2):($4) with lines title 'Packet Flow (Received)' linecolor rgb 'red'