import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:webview_flutter/webview_flutter.dart';
import 'dart:async';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  SystemChrome.setPreferredOrientations(
          [DeviceOrientation.landscapeLeft, DeviceOrientation.landscapeRight])
      .then((_) => runApp(MyApp()));
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: Home(),
    );
  }
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState(
        selectedUrl: "https://emp.rizmal.si/",
        title: "EMP",
      );
}

class _HomeState extends State<Home> {
  final String title;
  final String selectedUrl;
  final Completer<WebViewController> _controller =
      Completer<WebViewController>();
  _HomeState({
    @required this.title,
    @required this.selectedUrl,
  });

  @override
  void initState() {
    super.initState();
    SystemChrome.setPreferredOrientations([
      DeviceOrientation.landscapeRight,
      DeviceOrientation.landscapeLeft,
    ]);
  }

  Future<bool> _willPopCallback() async {
    _controller.future.then((_) => _.goBack());
    return false; // return true if the route to be popped
  }

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
      child: Scaffold(
        body: SafeArea(
          child: WebView(
            initialUrl: selectedUrl,
            javascriptMode: JavascriptMode.unrestricted,
            onWebViewCreated: (WebViewController webViewController) {
              _controller.complete(webViewController);
            },
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {
            _controller.future.then((_)=>_.reload());
          },
          child: Icon(Icons.replay),
          backgroundColor: Colors.green,
        ), // This trailing comma makes auto-formatting nicer for build methods.
      ),
      onWillPop: _willPopCallback,
    );
  }
}
