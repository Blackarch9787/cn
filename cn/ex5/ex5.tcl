set ns [new Simulator]
set tracefile [open CCS.tr w]
$ns trace-all $tracefile
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]set n3 [$ns node]
$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns duplex-link $n2 $n3 1Mb 10ms DropTail
set tcp [new Agent/TCP]
$ns attach-agent $n0 $tcp
set sink [new Agent/TCPSink]
$ns attach-agent $n3 $sink
$ns connect $tcp $sink
set ftp [new Application/FTP]
$ftp attach-agent $tcp
$ns at 0.0 "$ftp start"
$ns at 4.5 "$ftp stop"
$ns at 5.0 "finish"
proc finish {} {
global ns tracefile
$ns flush-trace
close $tracefile
exit 0
}
$ns run